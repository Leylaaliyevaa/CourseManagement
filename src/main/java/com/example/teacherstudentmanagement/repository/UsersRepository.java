package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
