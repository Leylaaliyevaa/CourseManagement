package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.LoginRequest;
import com.example.teacherstudentmanagement.dto.response.ExceptionDto;
import com.example.teacherstudentmanagement.dto.response.LoginResponse;
import com.example.teacherstudentmanagement.entity.Users;
import com.example.teacherstudentmanagement.repository.UsersRepository;
import com.example.teacherstudentmanagement.service.AuthService;
import com.example.teacherstudentmanagement.service.UsersService;
import com.example.teacherstudentmanagement.utility.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        log.info("login method started by: {}", loginRequest.getUsername());
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));
            log.info("authentication details: {}", authentication);
            String username = authentication.getName();
            Users users = new Users(username, "");
            String token = jwtUtil.createToken(users);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            LoginResponse loginRes = new LoginResponse(token);
            log.info("user: {} logged in", users.getUsername());
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(loginRes);

        } catch (BadCredentialsException e) {
            ExceptionDto exceptionDTO = new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Invalid username or password");
            log.error("Error due to {} ", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
        } catch (Exception e) {
            ExceptionDto exceptionDTO = new ExceptionDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            log.error("Error due to {} ", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
        }
    }
}
