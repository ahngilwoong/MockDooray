package com.nhnacademy.accountapi.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.accountapi.domain.Users;
import com.nhnacademy.accountapi.repository.UserRepository;
import com.nhnacademy.accountapi.request.UserRequest;
import com.nhnacademy.accountapi.response.UserResponse;
import com.nhnacademy.accountapi.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserRepository userRepository;
    private Users testUser;

    @BeforeEach
    void setUp(){
        // DB에 저장된 Test User 정보가 저장된 객체
        testUser = Users.builder().userId("gilung").userPwd("asd1234").userEmail("test@naver.com").userName("안길웅").build();
    }

    @Test
    void findByUserIdServiceTest(){
        //AUTO INCREAMENT 롤백 되지 않음.
        UserResponse findSuccessUser = accountService.findByUserId("gilung");
        assertThat(testUser.getUserId()).isEqualTo(findSuccessUser.getUserId());
    }



    @Test
    void registerServiceTest(){

//        UserRequest userRequest = new UserRequest("gilung02","asd1234","test2@naver.com","안길웅",UserStatus.);
//        accountService.register(userRequest);
        UserResponse findSuccessUser = accountService.findByUserId("gilung");
        assertThat(findSuccessUser).isNotNull();
    }


}