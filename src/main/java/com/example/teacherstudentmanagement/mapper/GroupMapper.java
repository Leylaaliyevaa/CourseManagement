package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.GroupStudentRequestDTO;
import com.example.teacherstudentmanagement.dto.response.GroupDTO;
import com.example.teacherstudentmanagement.dto.request.GroupRequestDTO;
import com.example.teacherstudentmanagement.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class, StudentMapper.class})
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);
    @Mapping(target = "teacherId", source = "teacher.id")
    GroupDTO toDTO(Group group);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teacher.id", source = "teacherId")
    Group toEntity(GroupRequestDTO groupRequestDTO);

    @Mapping(target = "id", source = "groupId")
    Group toGroup(GroupStudentRequestDTO groupStudentRequestDTO);
}


