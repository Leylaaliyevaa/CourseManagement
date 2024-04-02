package com.example.teacherstudentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@ToString
@NoArgsConstructor
@Table
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String gender;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Teacher teacher;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Student student;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    private Set<Authority> authorities = new HashSet<>();

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
