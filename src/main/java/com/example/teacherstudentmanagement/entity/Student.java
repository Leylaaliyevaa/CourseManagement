package com.example.teacherstudentmanagement.entity;

import com.example.teacherstudentmanagement.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Payment> payment;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Group> groups;

    private Integer remainingLessons;
    private LocalDateTime startDate;
    //private Date endDate;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    private Long monthlyLessons;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;
}
