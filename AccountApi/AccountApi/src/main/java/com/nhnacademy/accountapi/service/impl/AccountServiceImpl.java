package com.nhnacademy.accountapi.service.impl;

import com.nhnacademy.accountapi.domain.UserStatus;
import com.nhnacademy.accountapi.domain.Users;
import com.nhnacademy.accountapi.exception.AlreadyUserException;
import com.nhnacademy.accountapi.exception.UserNotFoundException;
import com.nhnacademy.accountapi.repository.UserRepository;
import com.nhnacademy.accountapi.request.UserRequest;
import com.nhnacademy.accountapi.response.UserResponse;
import com.nhnacademy.accountapi.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final UserRepository userRepository;

    @Override
    public UserResponse findByUserId(String userId) {
        UserResponse user = userRepository.findByUserId(userId)
        .orElseThrow(() -> new UserNotFoundException(userId + "No User With That Name Was Found."));
        return user;
    }

    @Override
    public UserResponse findByUserEmail(String userEmail) {
        UserResponse user = userRepository.findByUserEmail(userEmail)
            .orElseThrow(() -> new UserNotFoundException(userEmail + "No User With That Name Was Found."));
        return user;
    }

    @Override
    public UserResponse register(UserRequest request) {
        try{
            Users users = userRepository.save(
                Users.builder()
                    .userId(request.getUserId())
                    .userPwd(request.getUserPwd())
                    .userEmail(request.getUserEmail())
                    .userName(request.getUserName())
                    .userStatus(UserStatus.JOIN.getValue())
                    .build()
            );
            return new UserResponse(users.getUserNum(),users.getUserId(), users.getUserPwd(),users.getUserEmail(),users.getUserName(),users.getUserStatus());
        }catch(Exception e){
            throw new AlreadyUserException("Sorry, This User Already Exists.");
        }
    }
}
