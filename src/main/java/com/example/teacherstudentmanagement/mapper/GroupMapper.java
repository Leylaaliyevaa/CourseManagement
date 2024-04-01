package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.GroupDTO;
import com.example.teacherstudentmanagement.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class, StudentMapper.class})
public interface GroupMapper {

        GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

        GroupDTO toDTO(Group group);

        Group toEntity(GroupDTO groupDTO);
    }


