package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.LoginReg;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthorityService {
    ResponseEntity<?> authenticate(LoginReg loginReg);

    ResponseEntity<String> requestPasswordReset(String email);


}
