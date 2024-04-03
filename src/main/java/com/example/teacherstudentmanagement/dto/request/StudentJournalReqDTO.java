package com.example.teacherstudentmanagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;

@Data
public class StudentJournalReqDTO {
    @NotNull(message = "Student ID cannot be empty or null")
    @Min(value = 1)
    @Max(value = 3000)
    private Long studentId;

    @NotNull
    @Max(12)
    private Integer remainingLessons;

    @NotNull
    @Max(12)
    private Long monthlyLessons;
}
