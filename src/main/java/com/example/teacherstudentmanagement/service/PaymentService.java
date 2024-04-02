package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    void addPayment(HttpServletRequest request, PaymentRequestDTO paymentRequestDTO);
}
