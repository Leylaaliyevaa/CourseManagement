package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.UserEditReqDto;
import com.example.teacherstudentmanagement.dto.request.ChangePasswordDto;
import com.example.teacherstudentmanagement.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PatchMapping("/password")
    @ResponseStatus(HttpStatus.OK)
    public void changePassword(HttpServletRequest request, @RequestBody @Valid ChangePasswordDto changePasswordDto) {
        usersService.changePassword(request, changePasswordDto);
    }

    @PutMapping("/edit")
    public void updateUser(HttpServletRequest request,
                           @RequestBody @Valid UserEditReqDto userEditReqDto){
        usersService.updateUser(request, userEditReqDto);
    }

}
