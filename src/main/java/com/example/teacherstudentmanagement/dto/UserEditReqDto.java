package com.example.teacherstudentmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserEditReqDto {
    @Schema(hidden = true)
    private Long id;

    @NotBlank(message = "Username cannot be empty or null")
    @Size(max = 50)
    @Pattern(regexp = "[A-Za-z0-9_.]+$")
    private String username;

    @Schema(hidden = true)
    private String password;

    @Size(max = 15)
    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;

    @Size(max = 25)
    @NotBlank(message = "Surname cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String surname;

    @Email
    @NotBlank(message = "email cannot be empty or null")
    @Size(max = 40)
    private String email;

    @NotBlank(message = "phone can not be empty or null")
    @Pattern(regexp = "^\\+994[0-9]{9}$", message = "Invalid phone format")
    @Size(min = 10, max = 12)
    private String phone;

    @Size(max = 50)
    private String address;

    @NotBlank(message = "gender can not be null")
    private String gender;
}
