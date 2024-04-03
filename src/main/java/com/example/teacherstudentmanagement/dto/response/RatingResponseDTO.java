package com.example.teacherstudentmanagement.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RatingResponseDTO {
        private Long ratingId;
        private Long teacherId;
        private Long studentId;
        private Integer ratingValue;
        private String comment;
        private LocalDateTime timestamp;
}
