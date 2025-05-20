package com.mudemy.course.exception;

import lombok.Data;

@Data
public class CourseServiceException extends RuntimeException{

    private String errorCode;

    public CourseServiceException(String message,String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
