package com.mudemy.user.services;

import com.mudemy.user.dtos.CreateUserRequest;
import com.mudemy.user.dtos.UserResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest createUserRequest, HttpStatus created);
    List<UserResponse> getAllUsers();
}
