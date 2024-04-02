package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import com.example.teacherstudentmanagement.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPayment(HttpServletRequest request, @RequestBody PaymentRequestDTO paymentRequestDTO) {
        paymentService.addPayment(request, paymentRequestDTO);

    }

}
