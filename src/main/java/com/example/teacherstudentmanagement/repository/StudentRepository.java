package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.dto.projection.StudentProjection;
import com.example.teacherstudentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    StudentProjection findByUserId(Long userId);
}
