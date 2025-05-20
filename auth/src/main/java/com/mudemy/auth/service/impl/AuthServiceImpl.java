package com.mudemy.auth.service.impl;

import com.mudemy.auth.client.UserClient;
import com.mudemy.auth.config.TokenProvider;
import com.mudemy.auth.dto.AuthResponse;
import com.mudemy.auth.dto.LoginRequest;
import com.mudemy.auth.dto.RegisterRequest;
import com.mudemy.auth.dto.UserProfileRequest;
import com.mudemy.auth.exception.UserDisabledException;
import com.mudemy.auth.exception.UserNotFoundException;
import com.mudemy.auth.model.AuthUser;
import com.mudemy.auth.model.Role;
import com.mudemy.auth.model.RoleType;
import com.mudemy.auth.model.VerificationToken;
import com.mudemy.auth.repository.RoleRepository;
import com.mudemy.auth.repository.UserRepository;
import com.mudemy.auth.repository.VerificationTokenRepository;
import com.mudemy.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RoleRepository roleRepository;
    private final UserClient userClient;
    private final AuthenticationManager authenticationManager;
    private final VerificationTokenRepository verificationTokenRepository;

    public AuthResponse register(RegisterRequest request) {
        AuthUser user = new AuthUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role role = new Role();
        role.setName(RoleType.ROLE_STUDENT);
        roleRepository.save(role);
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        UserProfileRequest userProfileRequest = new UserProfileRequest();
        userProfileRequest.setEmail(request.getEmail());
        userProfileRequest.setUsername(request.getUsername());
        userProfileRequest.setFirstName(request.getFirstName());
        userProfileRequest.setPassword(passwordEncoder.encode(request.getPassword()));
        userProfileRequest.setProfileImageUrl(request.getProfileImageUrl());
        userProfileRequest.setFullName(request.getUsername() + " " + request.getLastName());
        userProfileRequest.setLastName(request.getLastName());

        userClient.createUserProfile(userProfileRequest);

        String token = UUID.randomUUID().toString();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(new Date());

        verificationTokenRepository.save(verificationToken);

        return new AuthResponse(user.getUsername());
    }

    @Override
    public boolean verifyUser(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);

        if (verificationToken.getToken().isEmpty()) {
            throw new RuntimeException("Not found registered user");
        }
        AuthUser user = verificationToken.getUser();
        user.setEnabled(true);
        verificationToken.setUser(user);
        userRepository.save(user);
        verificationTokenRepository.delete(verificationToken);

        return true;
    }

    public AuthResponse login(LoginRequest request) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        }catch (DisabledException ex) {
            throw new RuntimeException("Verify your email address before login");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if (!userDetails.isEnabled()){
            throw new UserDisabledException("Verify your email address before login");
        }

        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            throw new UserNotFoundException("User not found with this email address");
        }

        String token = tokenProvider.generateToken(userDetails);

        return new AuthResponse(token,userDetails.getUsername());
    }
}
