package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.GroupRequestDTO;
import com.example.teacherstudentmanagement.dto.request.GroupStudentRequestDTO;
import com.example.teacherstudentmanagement.dto.response.GroupDTO;
import com.example.teacherstudentmanagement.entity.Group;
import com.example.teacherstudentmanagement.entity.Student;
import com.example.teacherstudentmanagement.exception.NotFoundException;
import com.example.teacherstudentmanagement.mapper.GroupMapper;
import com.example.teacherstudentmanagement.repository.GroupRepository;
import com.example.teacherstudentmanagement.repository.StudentRepository;
import com.example.teacherstudentmanagement.service.GroupService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Transactional
    public GroupDTO add(GroupRequestDTO groupRequestDTO) {
        log.info("Group create method started");
        Group group = groupMapper.toEntity(groupRequestDTO);
        groupRepository.save(group);
        GroupDTO groupDTO = groupMapper.toDTO(group);
        log.info("Group created with the id: {}", group.getId());
        return groupDTO;
    }

    @Transactional
    public void addStudent(GroupStudentRequestDTO groupStudentRequestDTO) {
        log.info("Add student to group create method started");
        Group group = groupRepository.findById(groupStudentRequestDTO.getGroupId())
                .orElseThrow(() -> new NotFoundException("Group not found"));
        Student student = studentRepository.findById(groupStudentRequestDTO.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student not found"));

        group.getStudents().add(student);
        groupRepository.save(group);
        log.info("Student added to group with the ID: {}", student.getId());

    }
    public List<GroupDTO> showGroups() {
        log.info("Show all groups method started");
        List<Group> groups = groupRepository.findAll();
        List<GroupDTO> groupDTOS = groups.stream()
                .map(groupMapper::toDTO)
                .collect(Collectors.toList());
        log.info("Found {} groups", groups.size());
        return groupDTOS;
    }

    @Override
    public void delete(Long groupId) {
        log.info("Group delete method started");
        groupRepository.deleteById(groupId);
        log.info("Deleted a group with the ID: {}", groupId);
    }

}

