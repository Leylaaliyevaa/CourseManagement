package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;


@Service
public interface RatingService {

    void addRating(HttpServletRequest request, RatingRequestDTO ratingRequestDTO);

}
