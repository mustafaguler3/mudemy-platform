package com.mudemy.auth.dto;

import lombok.Data;

@Data
public class UserProfileRequest {
    private long id;
    private String username;
    private String fullName;
    private String profileImageUrl;
    private String email;
    private String firstName;
    private String lastName;
    private boolean active;
    private String phoneNumber;
    private String password;
}
