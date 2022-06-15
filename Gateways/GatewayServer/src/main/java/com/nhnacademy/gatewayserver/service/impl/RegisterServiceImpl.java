package com.nhnacademy.gatewayserver.service.impl;

import com.nhnacademy.gatewayserver.adaptor.AccountAdaptor;
import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.Users;
import com.nhnacademy.gatewayserver.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final AccountAdaptor adaptor;

    @Override
    public Optional<Users> registerUser(UserRequest userRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userRequest.setUserPwd(passwordEncoder.encode(userRequest.getUserPwd()));
        return adaptor.registerUserWithAccountApi(userRequest);
    }

}
