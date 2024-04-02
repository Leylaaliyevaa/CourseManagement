package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.GroupRequestDTO;
import com.example.teacherstudentmanagement.dto.request.GroupStudentRequestDTO;
import com.example.teacherstudentmanagement.dto.response.GroupDTO;
import com.example.teacherstudentmanagement.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
@Slf4j
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDTO createGroup(@RequestBody GroupRequestDTO groupRequestDTO) {
        return groupService.createGroup(groupRequestDTO);
    }

    @PostMapping("/add-student")
    @ResponseStatus(HttpStatus.OK)
    public void addStudentToGroup(@RequestBody GroupStudentRequestDTO groupStudentRequestDTO) {
        groupService.addStudentToGroup(groupStudentRequestDTO);
    }
}