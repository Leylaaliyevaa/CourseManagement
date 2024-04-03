package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.GroupRequestDTO;
import com.example.teacherstudentmanagement.dto.request.GroupStudentRequestDTO;
import com.example.teacherstudentmanagement.dto.response.GroupDTO;
import com.example.teacherstudentmanagement.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@Slf4j
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDTO create(@RequestBody GroupRequestDTO groupRequestDTO) {
        return groupService.add(groupRequestDTO);
    }

    @PostMapping("/add-student")
    @ResponseStatus(HttpStatus.OK)
    public void addStudent(@RequestBody @Valid GroupStudentRequestDTO groupStudentRequestDTO) {
        groupService.addStudent(groupStudentRequestDTO);
    }
    @GetMapping("/show")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDTO> getAll() {
        return groupService.showGroups();
    }


    @DeleteMapping("/delete/{groupId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid Long groupId) {
        groupService.delete(groupId);
    }
}