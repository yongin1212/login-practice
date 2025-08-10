package com.example.demo.controller;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserRequestDto dto, RedirectAttributes ra) {
        userService.signup(dto);
        ra.addFlashAttribute("msg(라고 쓰라 헀지만 뭔진 잘 모르겠다)", "회원가입 완료. 로그인 해주세요.");
        return "redirect:/login";
    }
}
