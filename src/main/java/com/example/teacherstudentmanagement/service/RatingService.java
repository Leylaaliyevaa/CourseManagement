package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import com.example.teacherstudentmanagement.dto.response.RatingResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RatingService {

    void addRating(HttpServletRequest request, RatingRequestDTO ratingRequestDTO);
//    List<RatingResponseDTO> showRatingByTeacherName(String teacherName);
 List<RatingResponseDTO> getAll();
     void deleteById(Long id);
//    RatingRequestDTO updateRatingByTeacherId(Long teacherId, RatingUpdateDTO ratingUpdateDTO);

}
