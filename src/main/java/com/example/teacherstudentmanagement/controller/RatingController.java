package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import com.example.teacherstudentmanagement.service.RatingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRating(HttpServletRequest request, @RequestBody RatingRequestDTO ratingRequestDTO) {
        ratingService.addRating(request, ratingRequestDTO);
    }


}
