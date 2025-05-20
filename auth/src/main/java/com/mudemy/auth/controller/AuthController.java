package com.mudemy.auth.controller;

import com.mudemy.auth.dto.AuthResponse;
import com.mudemy.auth.dto.LoginRequest;
import com.mudemy.auth.dto.RegisterRequest;
import com.mudemy.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verifyToken(@RequestParam("token") String token) {
        boolean isVerify = authService.verifyUser(token);
        if (isVerify) {
            return ResponseEntity.ok("User verfied");
        }else {
            return ResponseEntity.badRequest().body("User can not be verified");
        }
    }
}
