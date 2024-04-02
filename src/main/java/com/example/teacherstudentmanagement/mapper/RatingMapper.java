package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.RatingRequestDTO;
import com.example.teacherstudentmanagement.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface  RatingMapper {

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "teacherId", target = "teacher.id")
    Rating toEntity(RatingRequestDTO ratingRequestDTO);
}
