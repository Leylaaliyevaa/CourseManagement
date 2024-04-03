package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.UserEditReqDto;
import com.example.teacherstudentmanagement.dto.request.ChangePasswordDto;
import com.example.teacherstudentmanagement.entity.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    Users findByEmail(String email);

    void changePassword(HttpServletRequest request, ChangePasswordDto changePasswordDto);

    void updateUser(HttpServletRequest request, UserEditReqDto userEditReqDto);
}
