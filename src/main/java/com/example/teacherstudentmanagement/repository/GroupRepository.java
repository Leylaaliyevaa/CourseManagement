package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
