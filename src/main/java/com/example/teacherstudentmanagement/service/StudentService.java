package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.StudentJournalReqDTO;
import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.dto.request.UserStatusDto;
import com.example.teacherstudentmanagement.dto.response.StudentDTO;
import com.example.teacherstudentmanagement.entity.Student;
import com.example.teacherstudentmanagement.enums.StudentStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void create(StudentRegisterDTO studentDTO);
    List<StudentDTO> getAll();

    void delete(Long studentId);

    void updateStatus(UserStatusDto userStatusDto);

    void addStudentJournal(StudentJournalReqDTO studentJournalReqDTO);

    List<StudentDTO> getUserByStatus(StudentStatus studentStatus);

}
