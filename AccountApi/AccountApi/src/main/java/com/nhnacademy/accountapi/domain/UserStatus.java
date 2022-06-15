package com.nhnacademy.accountapi.domain;

public enum UserStatus {
    SLEEP("휴면"),
    JOIN("가입"),
    DELETE("탈퇴");

    private String value;

    UserStatus(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
