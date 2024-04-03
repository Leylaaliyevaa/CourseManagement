package com.example.teacherstudentmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ChangePasswordDto {
    @Size(min = 3, max = 30)
    @NotNull(message = "current password can not be null")
    @Pattern(regexp = "[A-Za-z0-9]+")
    private String currentPassword;

    @NotNull(message = "new password can not be null")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[A-Za-z0-9]+")
    private String newPassword;

    @NotNull(message = "retry password can not be null")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[A-Za-z0-9]+")
    private String retryPassword;
}
