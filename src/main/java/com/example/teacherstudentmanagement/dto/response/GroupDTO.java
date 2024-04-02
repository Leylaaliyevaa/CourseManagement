package com.example.teacherstudentmanagement.dto.response;
import com.example.teacherstudentmanagement.enums.Subjects;
import lombok.Data;

import java.util.List;
@Data
public class GroupDTO {
        private Long id;
        private Subjects subjects;
        private Long studentsNumber;
        private Long teacherId;
    }

