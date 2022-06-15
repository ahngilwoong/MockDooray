package com.nhnacademy.gatewayserver.service.impl;


import com.nhnacademy.gatewayserver.CustomAuthAdapter;
import com.nhnacademy.gatewayserver.adaptor.AccountAdaptor;
import com.nhnacademy.gatewayserver.exception.UserNotFoundException;
import com.nhnacademy.gatewayserver.response.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountAdaptor accountAdaptor;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users accountDbUser = accountAdaptor.getUserByIdFromAccountApi(username)
            .orElseThrow(() -> new UserNotFoundException(username + " No User With That Name Was Found."));
        return new User(accountDbUser.getUserId(),accountDbUser.getUserPwd(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER")));

    }
}
