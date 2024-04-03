package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import com.example.teacherstudentmanagement.dto.response.RatingResponseDTO;
import com.example.teacherstudentmanagement.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "teacherId", target = "teacher.id")
    Rating toEntity(RatingRequestDTO ratingRequestDTO);

    @Mapping(target = "teacherId", source = "rating.teacher.id")
    @Mapping(target = "studentId", source = "rating.student.id")
    RatingResponseDTO toRatingDTO(Rating rating);

    @Mapping(target = "teacher.id", source = "ratingRequestDTO.teacherId")
    @Mapping(target = "student.id", source = "ratingRequestDTO.studentId")
    public Rating toRatingEntity(RatingRequestDTO ratingRequestDTO);

    RatingRequestDTO toDTO(Rating rating);

//    List<RatingRequestDTO> toDTOs(List<Rating> ratings);
}
