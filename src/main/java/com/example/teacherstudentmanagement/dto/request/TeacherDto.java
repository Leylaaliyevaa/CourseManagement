package com.example.teacherstudentmanagement.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TeacherDto {
    @Schema(hidden = true)
    private Long id;
    @Schema(hidden = true)
    private Long userId;
    private String name;
    private String surname;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String gender;
}
