package com.example.teacherstudentmanagement.entity;

import com.example.teacherstudentmanagement.enums.Subjects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
@JsonIgnoreProperties("group")
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
