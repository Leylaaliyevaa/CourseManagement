package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
