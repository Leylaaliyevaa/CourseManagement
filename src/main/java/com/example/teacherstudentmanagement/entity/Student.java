package com.example.teacherstudentmanagement.entity;

import com.example.teacherstudentmanagement.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private Long remainingLessons;
    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    private Long monthlyLessons;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;
}
