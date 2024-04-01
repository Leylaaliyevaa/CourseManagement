package com.example.teacherstudentmanagement.repository;

import com.example.teacherstudentmanagement.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
