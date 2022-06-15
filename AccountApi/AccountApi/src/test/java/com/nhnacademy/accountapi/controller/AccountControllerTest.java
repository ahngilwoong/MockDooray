package com.nhnacademy.accountapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nhnacademy.accountapi.domain.UserStatus;
import com.nhnacademy.accountapi.domain.Users;
import com.nhnacademy.accountapi.repository.UserRepository;
import com.nhnacademy.accountapi.request.UserRequest;
import com.nhnacademy.accountapi.response.UserResponse;
import com.nhnacademy.accountapi.service.AccountService;
import com.nhnacademy.accountapi.service.impl.AccountServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AccountControllerTest {
    @LocalServerPort
    private int port;

    @MockBean
    private AccountService accountService;

    @Autowired
    TestRestTemplate testRestTemplate;

    private UserResponse testUser;
    private UserRequest request;

    @BeforeEach
    void setUp(){
        // DB에 저장된 Test User 정보가 저장된 객체
        testUser = new UserResponse(null,"gilung","asd1234","test@naver.com","안길웅", UserStatus.JOIN.getValue());
        request = new UserRequest("gilungss","asd1234","westheat@naver.com","BearYes",UserStatus.JOIN.getValue());
    }

    @Test
    @DisplayName("USER ID를 통해 객체 가져오는 REST GET 단위 테스트")
    void getUserByUserIdTest() throws Exception {
        when(this.accountService.findByUserId("gilung")).thenReturn(testUser);
        UserResponse result = testRestTemplate.getForObject("/account/user/gilung",UserResponse.class);
        assertThat(result.getUserId()).isEqualTo("gilung");
//        HttpSession
//        HttpEntity<UserRequest> request = new HttpEntity<>(request, headers);
//        ResponseEntity<String>
//            responseResult = this.testRestTemplate.exchange("http://localhost:"+port+"/account/user/gilung", HttpMethod.GET, request, String.class);
    }

    @Test
    @DisplayName("USER EMAIL을 통해 객체 가져오는 REST GET 단위 테스트")
    void getUserByUserEmailTest(){
        when(this.accountService.findByUserEmail("test@naver.com")).thenReturn(testUser);
        UserResponse result = testRestTemplate.getForObject("/account/email/test@naver.com",UserResponse.class);
        assertThat(result.getUserEmail()).isEqualTo("test@naver.com");
    }



    @Test
    @DisplayName("회원가입 등록 단위 테스트")
    void postRegisterUserTest() {
        String url = "http://localhost:" + this.port + "/account/register";
        when(this.accountService.register(any())).thenReturn(testUser);
        ResponseEntity<UserResponse> responseEntity =
            this.testRestTemplate.postForEntity(url, testUser, UserResponse.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getUserName()).isEqualTo(testUser.getUserName());
    }
}