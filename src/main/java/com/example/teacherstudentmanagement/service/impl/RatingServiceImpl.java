package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import com.example.teacherstudentmanagement.dto.request.RatingUpdateDTO;
import com.example.teacherstudentmanagement.dto.response.RatingResponseDTO;
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
import java.util.List;
import java.util.stream.Collectors;


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
        log.info("Payment add method finished by userId: {}", userId);
    }

    @Override
    public List<RatingResponseDTO> getAll() {
        List<Rating> ratings = ratingRepository.findAll();
        List<RatingResponseDTO> ratingResponseDTOS = ratings.stream()
                .map(ratingMapper::toRatingDTO)
                .collect(Collectors.toList());
        log.info("Found {} ratings", ratings.size());
        return ratingResponseDTOS;
    }

    @Override
    public void deleteById(Long id) {
        ratingRepository.deleteById(id);
    }

//    @Override
//    public RatingRequestDTO updateRatingByTeacherId(Long teacherId, RatingUpdateDTO ratingUpdateDTO) {
//        List<Rating> ratings = ratingRepository.findByTeacherId(teacherId);
//
//        for (Rating rating : ratings) {
//            rating.setRatingValue(ratingUpdateDTO.getRatingValue());
//            rating.setComment(ratingUpdateDTO.getComment());
//            rating.setTimestamp(LocalDateTime.now()); // You may want to update the timestamp as well
//        }
//
//        ratingRepository.saveAll(ratings);
//
//        return (RatingRequestDTO) ratingMapper.toDTOs(ratings);
//    }
    }

//    @Override
//    public List<RatingResponseDTO> showRatingByTeacherName(String teacherName) {
//        List<Rating> ratings = ratingRepository.findByTeacherName(teacherName);
//        return ratings.stream()
//                .map(ratingMapper::toRatingDTO)
//                .collect(Collectors.toList());
//    }

