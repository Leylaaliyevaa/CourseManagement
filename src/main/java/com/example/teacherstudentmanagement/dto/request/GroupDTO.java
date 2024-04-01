package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.Subjects;
import lombok.Data;

import java.util.List;
@Data
public class GroupDTO {
        private Long id;
        private Subjects subjects;
        private Long studentsNumber;
        private TeacherDto teacher;
        private List<StudentDto> students;
    }

