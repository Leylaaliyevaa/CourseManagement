package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.StudentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class StudentRegisterDTO {
    @NotBlank(message = "Name cannot be empty or null")
    @Size(max = 20)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String name;

    @NotBlank(message = "Surname cannot be empty or null")
    @Size(max = 20)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String surname;

    @NotBlank(message = "Username cannot be empty or null")
    @Size(max = 20)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String username;

    @NotBlank(message = "Password cannot be empty or null")
    @Size(min = 3)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String password;

    @Email
    @NotBlank(message = "Email cannot be empty or null")
    @Size(max = 25)
    private String email;

    @NotBlank(message = "Phone can not be empty or null")
    @Pattern(regexp = "^\\+994[0-9]{9}$", message = "Invalid phone format")
    private String phone;

    @Size(max = 50)
    private String address;

    @Size(max = 6)
    private String gender;

    @Getter
    @Schema(hidden = true)
    private Long id;
    private LocalDateTime startDate;

    @Schema(hidden = true)
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    public void setId(Long id) {
        this.id = id;
    }
}
