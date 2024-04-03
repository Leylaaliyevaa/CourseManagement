package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.dto.request.TeacherUpdateDTO;
import com.example.teacherstudentmanagement.dto.response.TeacherDTO;
import com.example.teacherstudentmanagement.enums.Subjects;
import com.example.teacherstudentmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid TeacherRequestDto teacherRequestDto) {
        teacherService.add(teacherRequestDto);
    }

    @GetMapping("/subjects/{subject}")
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDTO> showBySubjects(@PathVariable Subjects subject) {
        return teacherService.showBySubjects(subject);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDTO> getAll() {
        return teacherService.getAll();
    }
}
