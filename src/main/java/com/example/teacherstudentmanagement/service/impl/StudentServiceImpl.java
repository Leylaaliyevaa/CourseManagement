package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.StudentJournalReqDTO;
import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.dto.request.UserStatusDto;
import com.example.teacherstudentmanagement.dto.response.StudentDTO;
import com.example.teacherstudentmanagement.entity.Authority;
import com.example.teacherstudentmanagement.entity.Student;
import com.example.teacherstudentmanagement.entity.Users;
import com.example.teacherstudentmanagement.enums.AuthorityEnum;
import com.example.teacherstudentmanagement.enums.StudentStatus;
import com.example.teacherstudentmanagement.exception.AlreadyExistException;
import com.example.teacherstudentmanagement.exception.NotFoundException;
import com.example.teacherstudentmanagement.mapper.StudentMapper;
import com.example.teacherstudentmanagement.mapper.UsersMapper;
import com.example.teacherstudentmanagement.repository.StudentRepository;
import com.example.teacherstudentmanagement.repository.UsersRepository;
import com.example.teacherstudentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public void create(StudentRegisterDTO studentRegisterDTO) {
        log.info("student register method started by {}", studentRegisterDTO.getUsername());
        String username = studentRegisterDTO.getUsername();
        Optional<Users> optionalUsers = usersRepository.findByUsername(username);
        if (optionalUsers.isPresent()) {
            throw new AlreadyExistException("User already exist with this username");
        }
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority(AuthorityEnum.STUDENT.name()));

        studentRegisterDTO.setPassword(passwordEncoder.encode(studentRegisterDTO.getPassword()));
        studentRegisterDTO.setStartDate(LocalDateTime.now());
        studentRegisterDTO.setStatus(StudentStatus.ACTIVE);

        Users user = usersMapper.studentRegisterDTOToUser(studentRegisterDTO);
        user.setAuthorities(authorities);
        usersRepository.save(user);
        Student student = studentMapper.toEntity(studentRegisterDTO);
        student.setUser(user);
        studentRepository.save(student);
        log.info("student register method done by {}", user.getUsername());

    }

    @Override
    public List<StudentDTO> getAll() {
        log.info("Student getAll method started");
        List<StudentDTO> students = studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .toList();
        log.info("user getAll method done");
        return students;
    }

    @Override
    public void delete(Long studentId) {
        log.info("Student delete method started");
        studentRepository.deleteById(studentId);
        log.info("Student delete method done");

    }

    @Override
    public void updateStatus(UserStatusDto userStatusDto) {
        log.info("student updateStatus method start");
        Student student = studentRepository.findById(userStatusDto.getId())
                .orElseThrow(() -> new NotFoundException("Student not found"));
        student.setStatus(userStatusDto.getStudentStatus());
        studentRepository.save(student);
        log.info("User (userId: {}) status updated by admin", student.getId());
    }

    @Override
    public void addStudentJournal(StudentJournalReqDTO studentJournalReqDTO) {
        log.info("Journal add method started");
        Student student = studentRepository.findById(studentJournalReqDTO.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student not found"));

        student.setMonthlyLessons(studentJournalReqDTO.getMonthlyLessons());
        student.setRemainingLessons(studentJournalReqDTO.getRemainingLessons());
        studentRepository.save(student);
        log.info("Journal add method done");
    }

    @Override
    public List<StudentDTO> getUserByStatus(StudentStatus studentStatus) {
        log.info("student getStudentByStatus method started for userStatus: {}", studentStatus.name());
        List<StudentDTO> studentDTOS = studentRepository.findByStatus(studentStatus)
                .stream().map(studentMapper::toDTO).toList();
        if (studentDTOS.isEmpty()){
            throw new NotFoundException("Student not found with status: " + studentStatus);
        }
        log.info("student getStudentByStatus method done for userStatus: {}", studentStatus.name());
        return studentDTOS;
    }


}
