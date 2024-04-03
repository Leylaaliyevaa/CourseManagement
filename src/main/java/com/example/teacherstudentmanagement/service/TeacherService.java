package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.dto.response.TeacherDTO;
import com.example.teacherstudentmanagement.enums.Subjects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    void add(TeacherRequestDto teacherRequestDto);

    //   TeacherDto createTeacher(TeacherDto teacherDto);
    List<TeacherDTO> showBySubjects(Subjects subject);
    void delete(Long id);
    List<TeacherDTO> getAll();
}
