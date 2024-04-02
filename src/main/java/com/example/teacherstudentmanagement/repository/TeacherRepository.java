package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Teacher;
import com.example.teacherstudentmanagement.enums.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findBySubjects(Subjects subject);

}
