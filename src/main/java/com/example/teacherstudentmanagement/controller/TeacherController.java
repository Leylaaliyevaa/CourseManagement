package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid TeacherRequestDto teacherRequestDto){
        teacherService.add(teacherRequestDto);
    }
}
