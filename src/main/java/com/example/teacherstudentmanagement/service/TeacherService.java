package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    void add(TeacherRequestDto teacherRequestDto);
//   TeacherDto createTeacher(TeacherDto teacherDto);
}
