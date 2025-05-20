package com.mudemy.course.dto;

import com.mudemy.course.model.CourseLevel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private String thumbnailUrl;;
    private BigDecimal price;
    private String duration;
    private String language;
    private LocalDate publishedDate;
    private CourseLevel level;
    private Double rating;
    private Long totalStudents;
    private CategoryDto category;
}
