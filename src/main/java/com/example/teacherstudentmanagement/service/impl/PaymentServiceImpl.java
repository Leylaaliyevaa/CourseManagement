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

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;
    private final JwtUtil jwtUtil;
    @Transactional
    public void addPayment(HttpServletRequest request, PaymentRequestDTO paymentRequestDTO) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
        log.info("Payment add method started by userId: {}", userId);
        Long studentId = studentRepository.findByUserId(Long.valueOf(userId)).getId();

        Payment payment = paymentMapper.toPayment(paymentRequestDTO);
        payment.setStudent(new Student(studentId));
        paymentRepository.save(payment);
    }
}
