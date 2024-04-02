package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.GroupRequestDTO;
import com.example.teacherstudentmanagement.dto.request.GroupStudentRequestDTO;
import com.example.teacherstudentmanagement.dto.response.GroupDTO;
import com.example.teacherstudentmanagement.entity.Group;
import org.springframework.stereotype.Service;

@Service
public interface GroupService {
    GroupDTO createGroup(GroupRequestDTO groupRequestDTO);

    void addStudentToGroup(GroupStudentRequestDTO groupStudentRequestDTO);
}
