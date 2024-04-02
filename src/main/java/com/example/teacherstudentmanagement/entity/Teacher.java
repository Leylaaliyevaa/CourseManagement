package com.example.teacherstudentmanagement.entity;

import com.example.teacherstudentmanagement.enums.Subjects;
import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Group> group;

    @Enumerated(EnumType.STRING)
    private Subjects subjects;
    private Double rating;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;
}
