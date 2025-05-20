package com.mudemy.course.dto;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Data
@Getter
@Setter
public class ErrorResponse  {

    private String message;
    private String errorCode;

    public ErrorResponse() {
    }
}




























