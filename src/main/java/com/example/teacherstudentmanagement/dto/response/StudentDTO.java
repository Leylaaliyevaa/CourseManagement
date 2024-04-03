package com.example.teacherstudentmanagement.dto.response;

import com.example.teacherstudentmanagement.enums.StudentStatus;
import lombok.Data;

@Data
public class StudentDTO {
    private Long studentId;
    private Long userId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phone;
    private String address;
    private StudentStatus status;
}
