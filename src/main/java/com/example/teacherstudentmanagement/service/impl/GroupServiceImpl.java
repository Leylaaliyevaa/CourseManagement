package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.GroupRequestDTO;
import com.example.teacherstudentmanagement.dto.request.GroupStudentRequestDTO;
import com.example.teacherstudentmanagement.dto.response.GroupDTO;
import com.example.teacherstudentmanagement.entity.Group;
import com.example.teacherstudentmanagement.entity.Student;
import com.example.teacherstudentmanagement.mapper.GroupMapper;
import com.example.teacherstudentmanagement.repository.GroupRepository;
import com.example.teacherstudentmanagement.repository.StudentRepository;
import com.example.teacherstudentmanagement.service.GroupService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Transactional
    public GroupDTO createGroup(GroupRequestDTO groupRequestDTO) {
        Group group = groupMapper.toEntity(groupRequestDTO);
        groupRepository.save(group);
        GroupDTO groupDTO = groupMapper.toDTO(group);
        return groupDTO;
    }

    @Transactional
    public void addStudentToGroup(GroupStudentRequestDTO groupStudentRequestDTO) {
        Group group = groupRepository.findById(groupStudentRequestDTO.getGroupId()).orElseThrow(() -> new IllegalArgumentException("Group not found"));
        Student student = studentRepository.findById(groupStudentRequestDTO.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student not found"));

        group.getStudents().add(student);
        groupRepository.save(group);
    }
}

