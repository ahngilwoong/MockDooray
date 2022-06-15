package com.nhnacademy.accountapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class UserRequest {
    private String userId;
    private String userPwd;
    private String userEmail;
    private String userName;
    private String userStatus;
}
