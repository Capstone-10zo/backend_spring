package project.capstone.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.capstone.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class MemberController {

    private final MemberService memberService;
//
//    @GetMapping("/")
//    public String
}
