package com.nhnacademy.accountapi.response;


import com.nhnacademy.accountapi.domain.UserStatus;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserResponse {
    private Long userNum;
    private String userId;
    private String userPwd;
    private String userEmail;
    private String userName;
    private String  userStatus;
}
