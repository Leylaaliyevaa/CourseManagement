package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "select avg(rating_value) from rating where teacher_id = :teacherId", nativeQuery = true)
    Double findAverageRatingByTeacherId(@Param("teacherId") Long teacherId);

    //    List<Rating> findByTeacherName(String teacherName);
    List<Rating> findByTeacherId(Long teacherId);
}
