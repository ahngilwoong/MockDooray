package com.nhnacademy.gatewayserver.request;


import lombok.*;
import org.springframework.boot.jackson.JsonMixin;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String userId;
    private String userPwd;
    private String userEmail;
    private String userName;
    private String userStatus;
}
