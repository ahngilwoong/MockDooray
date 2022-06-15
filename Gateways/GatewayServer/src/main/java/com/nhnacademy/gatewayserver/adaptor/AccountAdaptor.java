package com.nhnacademy.gatewayserver.adaptor;


import com.nhnacademy.gatewayserver.request.UserRequest;
import com.nhnacademy.gatewayserver.response.Users;

import java.util.Optional;

public interface AccountAdaptor {
    Optional<Users> getUserByIdFromAccountApi(String userId);

    Optional<Users> registerUserWithAccountApi(UserRequest userRequest);

    Optional<Users> getUserByEmailFromAccountApi(String userEmail);
}
