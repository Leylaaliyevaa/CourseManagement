package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.GroupDTO;
import com.example.teacherstudentmanagement.entity.Group;
import com.example.teacherstudentmanagement.mapper.GroupMapper;
import com.example.teacherstudentmanagement.repository.GroupRepository;
import com.example.teacherstudentmanagement.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;


    private final GroupMapper groupMapper;

    public GroupDTO createGroup(GroupDTO groupDTO) {
        Group group = groupMapper.toEntity(groupDTO);
        group = groupRepository.save(group);
        return groupMapper.toDTO(group);
    }
}

