package com.nhnacademy.gatewayserver.service;

import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.Users;

import java.util.Optional;

public interface RegisterService{
    Optional<Users> registerUser(UserRequest userRequest);

}
