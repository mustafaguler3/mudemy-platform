package com.mudemy.course.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private BigDecimal price;
    private String duration;
    private String language;
    private LocalDate publishedDate;
    private CourseLevel level;
    private Double rating;
    private Long totalStudents;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}
