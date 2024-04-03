package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import com.example.teacherstudentmanagement.dto.response.RatingResponseDTO;
import com.example.teacherstudentmanagement.service.RatingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRating(HttpServletRequest request, @RequestBody @Valid RatingRequestDTO ratingRequestDTO) {
        ratingService.addRating(request, ratingRequestDTO);
    }

    //    @GetMapping("/teacher/{teacherName}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<RatingResponseDTO>> showRatingByTeacherName(@PathVariable String teacherName) {
//        List<RatingResponseDTO> ratings = ratingService.showRatingByTeacherName(teacherName);
//        return new ResponseEntity<>(ratings, HttpStatus.OK);
//    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RatingResponseDTO> getAll() {
        return ratingService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        ratingService.deleteById(id);
    }


//    @PutMapping("/teachers/{teacherId}")
//    public ResponseEntity<?> updateRatingByTeacherId(@PathVariable Long teacherId, @RequestBody @Valid RatingUpdateDTO ratingUpdateDTO) {
//        RatingRequestDTO updatedRating = ratingService.updateRatingByTeacherId(teacherId, ratingUpdateDTO);
//        return ResponseEntity.ok(updatedRating);
//    }
}
