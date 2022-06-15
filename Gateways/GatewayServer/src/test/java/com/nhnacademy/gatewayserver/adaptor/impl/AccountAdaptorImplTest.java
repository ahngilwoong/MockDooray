package com.nhnacademy.gatewayserver.adaptor.impl;

import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AccountAdaptorImplTest {
    @Autowired
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private HttpEntity request;


    @BeforeEach
    void setUp(){
        httpHeaders = new HttpHeaders();
    }

    @Test
    @DisplayName("Account Api에서 Rest 요청을 통해 아이디로 객체 가져오기 테스트")
    void getUserByIdFromAccountApiTest(){
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity<>(httpHeaders);
        String userId = "gilung";
        ResponseEntity<Users>
                response = restTemplate.exchange("http://localhost:4885/account/user/" + userId, HttpMethod.GET, request, Users.class);
        assertThat(response.getBody().getUserEmail()).isEqualTo("test@naver.com");
        System.out.println(response.getBody().toString());
    }


    @Test
    @DisplayName("Account Api에 회원 등록 요청")
    void registerUserWithAccountApiTest(){
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        UserRequest users = new UserRequest("gilungss","asd1234","test@naver.com","안길웅","가입");
        HttpEntity<UserRequest> entity = new HttpEntity<>(users,httpHeaders);
        ResponseEntity<Users> response = restTemplate.exchange("http://localhost:4885/account/register", HttpMethod.POST, entity, Users.class);

        assertThat(response.getBody().getUserName()).isEqualTo("안길웅");
    }


}