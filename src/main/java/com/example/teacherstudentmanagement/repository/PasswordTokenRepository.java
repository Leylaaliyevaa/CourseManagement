package com.example.teacherstudentmanagement.repository;

import com.example.teacherstudentmanagement.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);

    Optional<PasswordResetToken> findByUsersId(Long id);
}
