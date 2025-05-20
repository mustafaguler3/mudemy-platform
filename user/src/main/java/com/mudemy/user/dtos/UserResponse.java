package com.mudemy.user.dtos;

import com.mudemy.user.models.RoleType;
import lombok.Data;

@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private RoleType role;
}
