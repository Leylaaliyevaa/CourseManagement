package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.StudentStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;

@Data
public class UserStatusDto {
    @NotNull(message = "user id can not be null")
    @Min(value = 0)
    @Max(value = 3000)
    private Long id;

    private StudentStatus studentStatus;
}