package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
