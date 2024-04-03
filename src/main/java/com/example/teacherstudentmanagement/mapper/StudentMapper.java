package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.StudentJournalReqDTO;
import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.dto.response.StudentDTO;
import com.example.teacherstudentmanagement.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UsersMapper.class})
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

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

    @Mapping(source = "id", target = "studentId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "surname", source = "user.surname")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "address", source = "user.address")
    StudentDTO toDTO(Student student);

    @Mapping(target = "id", ignore = true)
    Student studentJournalReqDTOToStudent(StudentJournalReqDTO studentJournalReqDTO);

}
