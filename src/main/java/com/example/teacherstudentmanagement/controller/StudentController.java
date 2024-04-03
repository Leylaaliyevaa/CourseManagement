package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.StudentJournalReqDTO;
import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.dto.request.UserStatusDto;
import com.example.teacherstudentmanagement.dto.response.StudentDTO;
import com.example.teacherstudentmanagement.enums.StudentStatus;
import com.example.teacherstudentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid StudentRegisterDTO studentRegisterDTO) {
        studentService.create(studentRegisterDTO);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @PatchMapping("/status")
    public void updateStatus(@RequestBody @Valid UserStatusDto userStatusDto){
        studentService.updateStatus(userStatusDto);
    }

    @PostMapping("/journal")
    public void addStudentJournal(@RequestBody @Valid StudentJournalReqDTO studentJournalReqDTO) {
      studentService.addStudentJournal(studentJournalReqDTO);
    }

    @GetMapping("/byStatus")
    public List<StudentDTO> getUserByStatus(@RequestParam StudentStatus studentStatus){
        return studentService.getUserByStatus(studentStatus);
    }

    //
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateStudentDatas(@PathVariable Long id, @RequestBody @Valid StudentUpdateDTO updateDTO) {
//        studentService.updateStudentDatas(id, updateDTO);
//    }

//    @GetMapping("/status/{status}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<StudentDTO>> showStudentsByStatus(@PathVariable StudentStatus status) {
//        List<StudentDTO> students = studentService.showStudentsByStatus(status);
//        return new ResponseEntity<>(students, HttpStatus.OK);
//    }
}
