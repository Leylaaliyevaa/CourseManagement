package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.TeacherRequestDto;
import com.example.teacherstudentmanagement.dto.request.TeacherUpdateDTO;
import com.example.teacherstudentmanagement.dto.response.TeacherDTO;
import com.example.teacherstudentmanagement.entity.Authority;
import com.example.teacherstudentmanagement.entity.Teacher;
import com.example.teacherstudentmanagement.entity.Users;
import com.example.teacherstudentmanagement.enums.AuthorityEnum;
import com.example.teacherstudentmanagement.enums.Subjects;
import com.example.teacherstudentmanagement.exception.AlreadyExistException;
import com.example.teacherstudentmanagement.exception.NotFoundException;
import com.example.teacherstudentmanagement.mapper.TeacherMapper;
import com.example.teacherstudentmanagement.mapper.UsersMapper;
import com.example.teacherstudentmanagement.repository.RatingRepository;
import com.example.teacherstudentmanagement.repository.TeacherRepository;
import com.example.teacherstudentmanagement.repository.UsersRepository;
import com.example.teacherstudentmanagement.service.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final UsersMapper usersMapper;
    private final TeacherMapper teacherMapper;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final TeacherRepository teacherRepository;
    private final RatingRepository ratingRepository;

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

    @Override
    public List<TeacherDTO> showBySubjects(Subjects subject) {
        log.info("Show teacher method started");
        List<Teacher> teacher = teacherRepository.findBySubjects(subject);
        List<TeacherDTO> teacherDTOS = new ArrayList<>();
        for (Teacher t : teacher) {
            TeacherDTO teacherDTO = teacherMapper.toDTO(t);
            Double rating = ratingRepository.findAverageRatingByTeacherId(t.getId());
            teacherDTO.setRating(rating);
            teacherDTOS.add(teacherDTO);
        }

        log.info("Found {} teachers with a subject {}", teacher.size(), subject);
        return teacherDTOS;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete teacher method started");
        teacherRepository.deleteById(id);
        log.info("Delete teacher method done");
    }

    @Override
    public List<TeacherDTO> getAll() {
        log.info("Show all teachers method started");
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOS = new ArrayList<>();
            for (Teacher teacher : teachers){
                TeacherDTO teacherDTO = teacherMapper.toDTO(teacher);
                Double avgRating = ratingRepository.findAverageRatingByTeacherId(teacher.getId());
                teacherDTO.setRating(avgRating);
                teacherDTOS.add(teacherDTO);
            }
        log.info("Found {} teachers", teachers.size());
        return teacherDTOS;
    }
}



