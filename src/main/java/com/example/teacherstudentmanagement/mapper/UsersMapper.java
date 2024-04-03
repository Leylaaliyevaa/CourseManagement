package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.UserEditReqDto;
import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users studentRegisterDTOToUser(StudentRegisterDTO studentRegisterDTO);

    Users teacherRegisterDTOToUser(TeacherRequestDto teacherRequestDto);

    Users toUser(UserEditReqDto userEditReqDto);
}
