package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.Subjects;
import lombok.Data;

@Data
public class GroupRequestDTO {
    private Long teacherId;
    private Subjects subjects;
    private Long studentsNumber;
}
