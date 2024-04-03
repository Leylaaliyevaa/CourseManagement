package com.example.teacherstudentmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;
@Data
public class RatingUpdateDTO {
    @NotNull
    @Max(5)
    private Integer ratingValue;

    private String comment;
}
