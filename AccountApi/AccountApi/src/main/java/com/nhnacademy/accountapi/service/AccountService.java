package com.nhnacademy.accountapi.service;

import com.nhnacademy.accountapi.domain.Users;
import com.nhnacademy.accountapi.request.UserRequest;
import com.nhnacademy.accountapi.response.UserResponse;

public interface AccountService {
    UserResponse findByUserId(String userId);
    UserResponse register(UserRequest request);
    UserResponse findByUserEmail(String userEmail);
}
