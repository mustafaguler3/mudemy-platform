package com.mudemy.auth.service;

import com.mudemy.auth.client.UserClient;
import com.mudemy.auth.config.TokenProvider;
import com.mudemy.auth.dto.AuthResponse;
import com.mudemy.auth.dto.LoginRequest;
import com.mudemy.auth.dto.RegisterRequest;
import com.mudemy.auth.dto.UserProfileRequest;
import com.mudemy.auth.model.AuthUser;
import com.mudemy.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
    boolean verifyUser(String token);
}