package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.EmailDTO;
import com.example.teacherstudentmanagement.dto.request.LoginReg;
import com.example.teacherstudentmanagement.dto.request.LoginRequest;
import com.example.teacherstudentmanagement.dto.response.ExceptionDto;
import com.example.teacherstudentmanagement.dto.response.LoginResponse;
import com.example.teacherstudentmanagement.entity.PasswordResetToken;
import com.example.teacherstudentmanagement.entity.Users;
import com.example.teacherstudentmanagement.repository.PasswordTokenRepository;
import com.example.teacherstudentmanagement.service.AuthService;
import com.example.teacherstudentmanagement.service.EmailSenderService;
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

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsersService userService;
    private final PasswordTokenRepository tokenRepository;
    private final EmailSenderService emailSenderService;

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
            LoginResponse loginRes = new LoginResponse(username, token);
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

    @Override
    public ResponseEntity<?> authenticate(LoginReg loginReq) {
        log.info("authenticate method started by: {}", loginReq.getUsername());
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(),
                            loginReq.getPassword()));
            log.info("authentication details: {}", authentication);
            String username = authentication.getName();
            Users users = new Users(username, "");
            String token = jwtUtil.createToken(users);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            LoginResponse loginRes = new LoginResponse(username, token);
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

    @Override
    public ResponseEntity<String> requestPasswordReset(String email) {
        log.info("requestPasswordReset method started by: {}", email);
        Users user = userService.findByEmail(email);
        if (user == null) {
            log.info("user is null for requestPasswordReset method");
            return ResponseEntity.badRequest().body("User not found with this email!");
        }
        Long userId = user.getId();
        Optional<PasswordResetToken> passwordResetToken = tokenRepository.findByUsersId(userId);
        passwordResetToken.ifPresent(tokenRepository::delete);
        String newToken = generateRandomToken();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 5);
        Date expiryDate = calendar.getTime();


        EmailDTO receiverEmail = new EmailDTO();
        receiverEmail.setReceiver(email);
        receiverEmail.setText(newToken);
        receiverEmail.setSubject("CourseManagement - recovery password");
        try{
            emailSenderService.sendSimpleEmail(receiverEmail);
            createToken(user, newToken, expiryDate);
        }catch (Exception e){
            log.error("Error due to: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Email couldn't sent. Try again.");
        }
        log.info("token sent with email for recovery password to {}", email);
        return ResponseEntity.ok("Ok. Verify token was sent to your email");

    }

    private void createToken(Users user, String token, Date expiryDate) {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUsers(user);
        passwordResetToken.setToken(token);
        passwordResetToken.setExpiryDate(expiryDate);
        tokenRepository.save(passwordResetToken);
        log.info("Token created for forgot password function");
    }

    private String generateRandomToken() {
        SecureRandom random = new SecureRandom();
        int TOKEN_LENGTH = 32;
        byte[] bytes = new byte[TOKEN_LENGTH / 2];
        random.nextBytes(bytes);
        return new BigInteger(1, bytes).toString(16);
    }
}
