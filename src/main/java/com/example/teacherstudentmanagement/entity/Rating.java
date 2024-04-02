package com.example.teacherstudentmanagement.entity;

import lombok.Data;

import jakarta.persistence.*;
import javax.validation.constraints.Max; //validasiyani deyisersen istesen jakartaya
import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "student_id")
    private Student student;

    @Max(5)
    private Integer ratingValue;
    private String comment;
    private LocalDateTime timestamp;

}
