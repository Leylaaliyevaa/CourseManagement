package com.example.teacherstudentmanagement.entity;

import com.example.teacherstudentmanagement.enums.Subjects;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "teacher")
    private Group group;

    @Enumerated(EnumType.STRING)
    private Subjects subjects;
    private String username;
    private Long rating;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;
}
