package project.capstone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import project.capstone.domain.disease.Disease_info;
import project.capstone.domain.domain.Member;
import project.capstone.domain.domain.Pet;
import project.capstone.exception.NoMatchImageException;
import project.capstone.repository.disease.DiseaseRepositoryJpa;
import project.capstone.repository.member.MemberRepository;
import project.capstone.repository.pet.PetJpaRepository;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetService {

    private final PetJpaRepository petJpaRepository;
    private final MemberRepository memberRepository;
    private final DiseaseRepositoryJpa diseaseRepository;
    private final JsonProcessingService jsonProcessingService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final WebClient webClient = WebClient.builder().baseUrl(FASTAPI_URL).build();

    private static final String FASTAPI_URL = "http://localhost:8000";

    public Pet join(Pet pet, Long memberId) {
        Pet savedPet = petJpaRepository.save(pet);
        Member findMember = memberRepository.findById(memberId).get();
        savedPet.changeMember(findMember);
        return savedPet;
    }

    public Mono<String> ModelResultWithImage(MultipartFile file, String url) throws IOException {
        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return "file.jpg";  // 파일 이름 설정
            }
        }, MediaType.IMAGE_JPEG);  // 올바른 MIME 타입 사용 / JPEG로 통일

        try {
            Mono<String> result = webClient
                    .post()
                    .uri(url)
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .bodyValue(multipartBodyBuilder.build())
                    .retrieve()
                    .bodyToMono(String.class);
            Mono<Optional<Disease_info>> description = findDescription(result);

            return Mono.zip(result, description, (s1, s2) -> {
                try {
                    ObjectNode jsonNode = (ObjectNode) objectMapper.readTree(s1);
                    s2.ifPresent(diseaseInfo -> jsonNode.put("description", diseaseInfo.getDescription()));
                    log.info("success");
                    return jsonNode.toString();
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

            });

        } catch (Exception e) {
            throw new NoMatchImageException(e.getMessage());
        }
    }

    public Mono<Optional<Disease_info>> findDescription(Mono<String> result) throws JsonProcessingException {

        return result.flatMap(json -> {
            try {
                JsonNode jsonNode = objectMapper.readTree(json);
                String disease_name = jsonNode.path("disease_name").asText();
                log.info(disease_name);
                return Mono.fromCallable(() -> diseaseRepository.findByName(disease_name))
                        .subscribeOn(Schedulers.boundedElastic());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
