package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import com.example.teacherstudentmanagement.entity.Rating;
import com.example.teacherstudentmanagement.mapper.RatingMapper;
import com.example.teacherstudentmanagement.repository.RatingRepository;
import com.example.teacherstudentmanagement.repository.StudentRepository;
import com.example.teacherstudentmanagement.service.RatingService;
import com.example.teacherstudentmanagement.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingMapper ratingMapper;
    private final RatingRepository ratingRepository;
    private final StudentRepository studentRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public void addRating(HttpServletRequest request, RatingRequestDTO ratingRequestDTO) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
        log.info("Payment add method started by userId: {}", userId);
        Long studentId = studentRepository.findByUserId(Long.valueOf(userId)).getId();
        ratingRequestDTO.setStudentId(studentId);
        ratingRequestDTO.setTimestamp(LocalDateTime.now());
        Rating rating = ratingMapper.toEntity(ratingRequestDTO);
        ratingRepository.save(rating);
    }
}
