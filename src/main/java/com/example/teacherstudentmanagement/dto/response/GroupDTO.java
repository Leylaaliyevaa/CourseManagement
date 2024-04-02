package com.example.teacherstudentmanagement.dto.response;

import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.dto.request.TeacherDto;
import com.example.teacherstudentmanagement.enums.Subjects;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Data
public class GroupDTO {
        private Long id;
        private Subjects subjects;
        private Long studentsNumber;
        private Long teacherId;
    }

