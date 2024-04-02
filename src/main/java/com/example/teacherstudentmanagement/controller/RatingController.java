//package com.example.teacherstudentmanagement.controller;
//
//import com.example.teacherstudentmanagement.dto.request.RatingDTO;
//import com.example.teacherstudentmanagement.dto.request.RatingRegDTO;
//import com.example.teacherstudentmanagement.dto.request.TeacherRatingDTO;
//import com.example.teacherstudentmanagement.service.RatingService;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/rating")
//public class RatingController {
//    private final RatingService ratingService;
//
//    @PostMapping("/new")
//    @ResponseStatus(HttpStatus.CREATED)
//    public RatingDTO add(HttpServletRequest request, @RequestBody RatingRegDTO ratingReqDTO) {
//        return ratingService.add(request, ratingReqDTO);
//    }
//
//    @GetMapping("/{restaurantName}")
//    public ResponseEntity<TeacherRatingDTO> getTeacherRatings(@PathVariable String teacherName) {
//        TeacherRatingDTO restaurantRatingDTO = ratingService.getTeacherRatingByName(teacherName);
//        return new ResponseEntity<>(restaurantRatingDTO, HttpStatus.OK);
//    }
//}
