package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.UserEditReqDto;
import com.example.teacherstudentmanagement.dto.request.ChangePasswordDto;
import com.example.teacherstudentmanagement.entity.Users;
import com.example.teacherstudentmanagement.exception.BadRequestException;
import com.example.teacherstudentmanagement.exception.NotFoundException;
import com.example.teacherstudentmanagement.mapper.UsersMapper;
import com.example.teacherstudentmanagement.repository.UsersRepository;
import com.example.teacherstudentmanagement.service.UsersService;
import com.example.teacherstudentmanagement.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersMapper userMapper;
    private final UsersRepository usersRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found with ID"));
    }

    @Override
    public void changePassword(HttpServletRequest request, ChangePasswordDto changePasswordDto) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
        log.info("user changePassword method started by userId: {}", userId);
        Users user = usersRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
        if(changePasswordDto.getNewPassword().equals(changePasswordDto.getRetryPassword()) &&
                passwordEncoder.matches(changePasswordDto.getCurrentPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
            usersRepository.save(user);
            log.info("Password changed by user_id = {}", userId);
        }else {
            log.error("failed to change password");
            throw new BadRequestException("Old password entered incorrectly or new passwords do not match");
        }
    }

    @Override
    public void updateUser(HttpServletRequest request, UserEditReqDto userEditReqDto) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
        log.info("user updateUser method started by userId: {}", userId);
        userEditReqDto.setId(Long.valueOf(userId));
        Users user = usersRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
        userEditReqDto.setPassword(user.getPassword());
        usersRepository.save(userMapper.toUser(userEditReqDto));
        log.info("User record updated by userId: {}", userId);
    }
}
