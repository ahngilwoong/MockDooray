package com.nhnacademy.gatewayserver.adaptor.impl;

import com.nhnacademy.gatewayserver.adaptor.MemberAdaptor;
import com.nhnacademy.gatewayserver.request.MemberRequest;
import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class MemberAdaptorImpl implements MemberAdaptor {

    private final RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    @Override
    public Long findMemberNum(String userId) {
        httpHeaders = new HttpHeaders();
        HttpEntity request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Long>
                response = restTemplate.exchange("http://localhost:1004/member/findmember/" + userId, HttpMethod.GET, request, Long.class);
        return response.getBody();
    }

    @Override
    public void registerMemberToProject(MemberRequest memberRequest) {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MemberRequest> entity = new HttpEntity<>(memberRequest,httpHeaders);
        restTemplate.exchange("http://localhost:1004/addmember", HttpMethod.POST, entity, Void.class);
    }
}
