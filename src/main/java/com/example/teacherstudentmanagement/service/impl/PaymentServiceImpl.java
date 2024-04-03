package com.example.teacherstudentmanagement.service.impl;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import com.example.teacherstudentmanagement.entity.Payment;
import com.example.teacherstudentmanagement.entity.Student;
import com.example.teacherstudentmanagement.mapper.PaymentMapper;
import com.example.teacherstudentmanagement.repository.PaymentRepository;
import com.example.teacherstudentmanagement.repository.StudentRepository;
import com.example.teacherstudentmanagement.service.PaymentService;
import com.example.teacherstudentmanagement.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public void add(HttpServletRequest request, PaymentRequestDTO paymentRequestDTO) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
        log.info("Payment add method started by userId: {}", userId);
        Long studentId = studentRepository.findByUserId(Long.valueOf(userId)).getId();

        Payment payment = paymentMapper.toPayment(paymentRequestDTO);
        payment.setStudent(new Student(studentId));
        paymentRepository.save(payment);
        log.info("Payment add method done");

    }

    @Override
    public List<PaymentRequestDTO> getAll() {
        log.info("Show all payment method started");
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentRequestDTO> paymentDTOs = payments.stream()
                .map(paymentMapper::toDTO)
                .collect(Collectors.toList());
        log.info("Found {} payment", payments.size());
        return paymentDTOs;
    }

    @Override
    public List<PaymentRequestDTO> byStudentId(Long studentId) {
        log.info("Show payment by student id method started");
        List<Payment> payments = paymentRepository.findByStudentId(studentId);
        List<PaymentRequestDTO> paymentRequestDTOS = paymentMapper.toDTOList(payments);
        log.info("Payment show method done for student ID: {} ", studentId);
        return paymentRequestDTOS;
    }

}
