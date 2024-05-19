package project.capstone.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import project.capstone.domain.api.PredictionResponse;
import project.capstone.service.ChatbotService;
import project.capstone.service.PetService;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 모든 도메인에서의 접근을 허용
//172.30.1.88
public class HomeController {
    private static final String FASTAPI_URL = "http://localhost:8000";
    private final WebClient webClient = WebClient.builder().baseUrl(FASTAPI_URL).build();
    private final PetService petService;
    private final ChatbotService chatbotService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/fastapi")
    public Mono<String> fastapi_date(){
        Mono<String> mono = webClient.get()
                .uri("/data")
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }

    @GetMapping("/api")
    public Map<String, PredictionResponse>  api(){
        Map<String, PredictionResponse> response = webClient.get()
                .uri("/predict")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return response;
    }

    // http://172.30.1.88:8080/api2 집 기준
//    @PostMapping("/api2")
//    public Mono<String> api2(@RequestParam("file") MultipartFile file) throws IOException {
//        return petService.ModelResultWithImage(file);
//    }

    @PostMapping("/api2")
    public String api2(@RequestParam("file") MultipartFile file) throws IOException {
        return "ok";
    }

//    @PostMapping("/chatbot")
//    public String chatbot(@RequestParam("request") String request){
//        chatbotService.getResponse(request);
//        return "ok";
//    }

}

