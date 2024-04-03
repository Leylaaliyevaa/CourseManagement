package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.Subjects;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class GroupRequestDTO {
    @NotNull(message = "Teacher ID cannot be empty or null")
    @Min(value = 1)
    @Max(value = 3000)
    private Long teacherId;

    @NotBlank
    private Subjects subjects;

    @NotNull(message = "Student Number cannot be empty or null")
    @Min(value = 3)
    @Max(value = 10)
    private Long studentsNumber;
}
