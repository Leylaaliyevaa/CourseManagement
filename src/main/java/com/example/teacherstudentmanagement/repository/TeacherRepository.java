package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
