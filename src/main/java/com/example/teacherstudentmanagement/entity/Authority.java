package com.example.teacherstudentmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    @Id
    private String name;
}
