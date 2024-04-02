package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(source = "name", target = "user.name")
    @Mapping(source = "surname", target = "user.surname")
    @Mapping(source = "username", target = "user.username")
    @Mapping(source = "password", target = "user.password")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "phone", target = "user.phone")
    @Mapping(source = "address", target = "user.address")
    @Mapping(source = "gender", target = "user.gender")
    Teacher toEntity(TeacherRequestDto teacherRequestDto);

}
