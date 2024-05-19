package project.capstone.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import project.capstone.service.ChatbotService;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ChatbotController {


    private final ChatbotService chatbotService;

    @PostMapping("/chatbot")
    public Mono<String> getChatbotResponse(@RequestBody String request){

        return chatbotService.getResponse(request);
    }
}
