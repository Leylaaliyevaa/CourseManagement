package com.example.teacherstudentmanagement.controller;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import com.example.teacherstudentmanagement.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(HttpServletRequest request, @RequestBody @Valid PaymentRequestDTO paymentRequestDTO) {
        paymentService.add(request, paymentRequestDTO);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentRequestDTO> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentRequestDTO> byStudentId(@PathVariable Long studentId) {
        return paymentService.byStudentId(studentId);
    }
}
