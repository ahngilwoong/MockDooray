package com.nhnacademy.gatewayserver;

import com.nhnacademy.gatewayserver.response.CustomResponse;
import com.nhnacademy.gatewayserver.response.Users;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;

public class CustomAuthAdapter {

    // Redis 디시리얼라이즈 오류
    public static CustomResponse getCustomResponse(Users users){
        return new CustomResponse(users.getUserId(), users.getUserPwd(), "ROLE_MEMBER");
    }

}
