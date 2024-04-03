package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {

    void add(HttpServletRequest request, PaymentRequestDTO paymentRequestDTO);
     List<PaymentRequestDTO> getAll();
    List<PaymentRequestDTO> byStudentId(Long studentId);
}
