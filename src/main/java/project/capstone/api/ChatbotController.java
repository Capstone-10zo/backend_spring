package project.capstone.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.capstone.service.ChatbotService;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin// 모든 도메인에서의 접근을 허용
@Slf4j
public class ChatbotController {


    private final ChatbotService chatbotService;

    @PostMapping("/chatbot")
    public Mono<String> getChatbotResponse(@RequestBody String request){
        log.info("hello22");
        log.info(request);

        Mono<String> response = chatbotService.getResponse(request);
        log.info("ok");
        return response;
    }
}
