package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.StudentRegisterDTO;
import com.example.teacherstudentmanagement.entity.*;
import com.example.teacherstudentmanagement.enums.AuthorityEnum;
import com.example.teacherstudentmanagement.exception.AlreadyExistException;
import com.example.teacherstudentmanagement.mapper.StudentMapper;
import com.example.teacherstudentmanagement.mapper.TeacherMapper;
import com.example.teacherstudentmanagement.mapper.UsersMapper;
import com.example.teacherstudentmanagement.repository.StudentRepository;
import com.example.teacherstudentmanagement.repository.TeacherRepository;
import com.example.teacherstudentmanagement.repository.UsersRepository;
import com.example.teacherstudentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
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

    public void createStudent(StudentRegisterDTO studentRegisterDTO) {
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

        Users user = usersMapper.studentRegisterDTOToUser(studentRegisterDTO);
        user.setAuthorities(authorities);
        usersRepository.save(user);
        Student student = studentMapper.toEntity(studentRegisterDTO);
        student.setUser(user);
        studentRepository.save(student);
        log.info("student register method done by {}", user.getUsername());

    }

}
