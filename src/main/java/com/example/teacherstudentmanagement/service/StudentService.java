package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.entity.Group;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    void createStudent(StudentRegisterDTO studentDTO);
}
