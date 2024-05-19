package project.capstone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import project.capstone.repository.disease.DiseaseRepositoryJpa;
import project.capstone.repository.member.MemberRepository;
import project.capstone.repository.pet.PetJpaRepository;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatbotService {

    private static final String FASTAPI_URL = "http://localhost:8000";
    private final WebClient webClient = WebClient.builder().baseUrl(FASTAPI_URL).build();

    public Mono<String> getResponse(String request){
        try{
            return webClient.post()
                    .uri("/chatbot")
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(String.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
