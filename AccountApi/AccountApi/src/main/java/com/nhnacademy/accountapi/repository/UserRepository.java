package com.nhnacademy.accountapi.repository;

import com.nhnacademy.accountapi.domain.Users;
import com.nhnacademy.accountapi.response.UserResponse;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
        Optional<UserResponse> findByUserId(String userId);
        Optional<UserResponse> findByUserEmail(String userEmail);
}

