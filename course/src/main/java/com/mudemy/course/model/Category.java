package com.mudemy.course.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String coverUrl;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Course> courses;

    public Category() {
    }

    public Category(String name, String coverUrl) {
        this.name = name;
        this.coverUrl = coverUrl;
    }
}

























