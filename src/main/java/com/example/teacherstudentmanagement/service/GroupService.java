package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.GroupRequestDTO;
import com.example.teacherstudentmanagement.dto.request.GroupStudentRequestDTO;
import com.example.teacherstudentmanagement.dto.response.GroupDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    GroupDTO add(GroupRequestDTO groupRequestDTO);

    void addStudent(GroupStudentRequestDTO groupStudentRequestDTO);
     List<GroupDTO> showGroups();
    void delete(Long teacherId);

}
