package com.mudemy.auth.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String detail;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime now, int value, String message, String unexpectedError) {
        this.timestamp = now;
        this.status = value;
        this.message = message;
        this.detail = unexpectedError;
    }
}
