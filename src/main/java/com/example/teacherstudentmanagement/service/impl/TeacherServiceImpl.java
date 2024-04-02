package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.entity.Authority;
import com.example.teacherstudentmanagement.entity.Teacher;
import com.example.teacherstudentmanagement.entity.Users;
import com.example.teacherstudentmanagement.enums.AuthorityEnum;
import com.example.teacherstudentmanagement.exception.AlreadyExistException;
import com.example.teacherstudentmanagement.mapper.TeacherMapper;
import com.example.teacherstudentmanagement.mapper.UsersMapper;
import com.example.teacherstudentmanagement.repository.TeacherRepository;
import com.example.teacherstudentmanagement.repository.UsersRepository;
import com.example.teacherstudentmanagement.service.TeacherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final UsersMapper usersMapper;
    private final TeacherMapper teacherMapper;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final TeacherRepository teacherRepository;

    @Override
    @Transactional
    public void add(TeacherRequestDto teacherRequestDto) {
        log.info("teacher register method started by {}", teacherRequestDto.getUsername());
        String username = teacherRequestDto.getUsername();
        Optional<Users> optionalUsers = usersRepository.findByUsername(username);
        if (optionalUsers.isPresent()) {
            throw new AlreadyExistException("User already exist with this username");
        }
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority(AuthorityEnum.TEACHER.name()));

        teacherRequestDto.setPassword(passwordEncoder.encode(teacherRequestDto.getPassword()));
        Users user = usersMapper.teacherRegisterDTOToUser(teacherRequestDto);
        user.setAuthorities(authorities);
        usersRepository.save(user);
        Teacher teacher = teacherMapper.toEntity(teacherRequestDto);
        teacher.setUser(user);
        teacherRepository.save(teacher);
        log.info("teacher register method done by {}", user.getUsername());
    }

}
