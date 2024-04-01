package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.LoginReg;
import org.springframework.http.ResponseEntity;

public interface AuthorityService {
    ResponseEntity<?> authenticate(LoginReg loginReg);

    ResponseEntity<String> requestPasswordReset(String email);


}
