package com.nhnacademy.gatewayserver.controller;

import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @GetMapping("/register")
    public String getRegisterRequestAccess(){
        return "register";
    }

    @PostMapping("/register/create")
    public String postRegisterRequestAccess(@ModelAttribute UserRequest userRequest){
        registerService.registerUser(userRequest);
        return "redirect:/";
    }
}
