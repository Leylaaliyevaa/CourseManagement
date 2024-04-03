package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.LoginReg;
import com.example.teacherstudentmanagement.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<?> login(LoginRequest loginRequest);

    //    ResponseEntity<?> login(LoginRequest loginRequest);
    ResponseEntity<?> authenticate(LoginReg loginReq);

    ResponseEntity<String> requestPasswordReset(String email);


}
