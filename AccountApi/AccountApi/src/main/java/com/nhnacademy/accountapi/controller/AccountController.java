package com.nhnacademy.accountapi.controller;


import com.nhnacademy.accountapi.domain.Users;
import com.nhnacademy.accountapi.request.UserRequest;
import com.nhnacademy.accountapi.response.UserResponse;
import com.nhnacademy.accountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/user/{userId}")
    public UserResponse getUserByUserId(@PathVariable String userId){
        return accountService.findByUserId(userId);
    }

    @GetMapping("/email/{userEmail}")
    public UserResponse getUserByUserEmail(@PathVariable String userEmail){
        return accountService.findByUserEmail(userEmail);
    }

    @PostMapping("/register")
    public UserResponse Register(@RequestBody UserRequest request){
        return accountService.register(request);
    }
}
