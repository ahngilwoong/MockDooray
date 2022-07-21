package com.nhnacademy.gatewayserver.adaptor.impl;


import com.nhnacademy.gatewayserver.adaptor.AccountAdaptor;
import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountAdaptorImpl implements AccountAdaptor {
    private final RestTemplate restTemplate;

    @Override
    public Optional<Users> getUserByIdFromAccountApi(String userId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Users>
            response = restTemplate.exchange("http://localhost:4885/account/user/" + userId, HttpMethod.GET, request, Users.class);
        return Optional.of(response.getBody());
    }

    @Override
    public Optional<Users> registerUserWithAccountApi(UserRequest userRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserRequest> entity = new HttpEntity<>(userRequest,httpHeaders);
        ResponseEntity<Users> response = restTemplate.exchange("http://localhost:4885/account/register", HttpMethod.POST, entity, Users.class);
        return Optional.of(response.getBody());
    }

    @Override
    public Optional<Users> getUserByEmailFromAccountApi(String userEmail) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Users>
            response = restTemplate.exchange("http://localhost:4885/account/email/" + userEmail, HttpMethod.GET, request, Users.class);
        return Optional.of(response.getBody());
    }

    @Override
    public Long getUserIdByUserNum(String userId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Long>
                response = restTemplate.exchange("http://localhost:4885/account/user/" + userId, HttpMethod.GET, request, Long.class);
        return response.getBody();
    }

}
