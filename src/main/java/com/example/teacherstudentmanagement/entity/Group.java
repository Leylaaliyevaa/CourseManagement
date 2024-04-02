package com.example.teacherstudentmanagement.entity;

import com.example.teacherstudentmanagement.enums.Subjects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private Subjects subjects;

    private Long studentsNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "student_group",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")})
    private List<Student> students;
}
