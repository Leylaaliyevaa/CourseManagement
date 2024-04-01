package com.example.teacherstudentmanagement.repository;


import com.example.teacherstudentmanagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
