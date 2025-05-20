package com.mudemy.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Email address is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
