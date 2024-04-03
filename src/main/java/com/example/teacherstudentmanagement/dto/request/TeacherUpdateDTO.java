package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.Subjects;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;

@Data
public class TeacherUpdateDTO {
    @NotNull(message = "Teacher ID cannot be empty or null")
    @Min(value = 1)
    @Max(value = 3000)
    private Long id;

    @NotBlank
    private Subjects subjects;

    @Schema(hidden = true)
    private Double rating;
}
