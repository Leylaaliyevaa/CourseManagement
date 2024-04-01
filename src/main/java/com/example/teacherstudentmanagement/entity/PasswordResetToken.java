package com.example.teacherstudentmanagement.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
