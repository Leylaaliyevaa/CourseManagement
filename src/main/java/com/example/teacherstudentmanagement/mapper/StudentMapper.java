package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring", uses = {UsersMapper.class})
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    //StudentRegisterDTO toDTO(Student student);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", ignore = true)
    @Mapping(target = "remainingLessons", ignore = true)
    @Mapping(target = "monthlyLessons", ignore = true)
    @Mapping(source = "name", target = "user.name")
    @Mapping(source = "surname", target = "user.surname")
    @Mapping(source = "username", target = "user.username")
    @Mapping(source = "password", target = "user.password")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "phone", target = "user.phone")
    @Mapping(source = "address", target = "user.address")
    @Mapping(source = "gender", target = "user.gender")
    Student toEntity(StudentRegisterDTO studentDTO);


}
