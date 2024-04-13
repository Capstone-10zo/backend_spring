package project.capstone.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    @CrossOrigin(origins = "*") // 모든 도메인에서의 접근을 허용
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}

