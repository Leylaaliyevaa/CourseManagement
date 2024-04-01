package com.example.teacherstudentmanagement.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table
public class Authority {
    @Id
    private String name;
}
