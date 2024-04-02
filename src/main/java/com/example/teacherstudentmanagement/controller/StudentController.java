package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.entity.Group;
import com.example.teacherstudentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid StudentRegisterDTO studentRegisterDTO){
        studentService.createStudent(studentRegisterDTO);
    }
}
