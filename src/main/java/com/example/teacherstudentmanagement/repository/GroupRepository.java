package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
