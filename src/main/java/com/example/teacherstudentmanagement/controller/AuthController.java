package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.LoginRequest;
import com.example.teacherstudentmanagement.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
