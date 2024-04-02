package com.example.teacherstudentmanagement.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RatingRequestDTO {
    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private Long studentId;

    @NotNull(message = "Teacher ID can not be null")
    private Long teacherId;

    @Min(value = 0)
    @Max(value = 5)
    @NotNull(message = "Rating value can not be null!")
    private Integer ratingValue;

    private String comment;

    @Schema(hidden = true)
    private LocalDateTime timestamp;
}
