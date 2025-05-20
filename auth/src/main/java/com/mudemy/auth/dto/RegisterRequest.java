package com.mudemy.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String profileImageUrl;
    private String firstName;
    private String lastName;
    private String fullName;
    private boolean active;
    private String phoneNumber;
}
