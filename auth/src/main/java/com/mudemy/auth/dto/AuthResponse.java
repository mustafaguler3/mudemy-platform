package com.mudemy.auth.dto;

import lombok.Data;

@Data
public class AuthResponse {

    private String accessToken;
    private String username;

    public AuthResponse() {
    }

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponse(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }
}
