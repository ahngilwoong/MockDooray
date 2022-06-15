package com.nhnacademy.gatewayserver.response;


import lombok.*;
import org.springframework.boot.jackson.JsonMixin;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@Builder
public class Users {
    private Long userNum;
    private String userId;
    private String userPwd;
    private String userEmail;
    private String userName;
    private String userStatus;

    public Users(Long userNum, String userId, String userPwd, String userEmail,
                 String userName, String userStatus) {
        this.userNum = userNum;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userStatus = userStatus;
    }
}
