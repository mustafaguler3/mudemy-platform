package com.mudemy.course.utility;

import com.mudemy.course.model.Category;
import com.mudemy.course.model.Course;
import com.mudemy.course.model.CourseLevel;
import com.mudemy.course.repository.CategoryRepository;
import com.mudemy.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
@Slf4j
@RequiredArgsConstructor
public class SeedDataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final CourseRepository courseRepository;


    @Override
    public void run(String... args) throws Exception {

        Category categoryAngular = categoryRepository.findCategoryById(2);
        Course course = new Course();
        course.setThumbnailUrl("/images/angular.png");
        course.setCategory(categoryAngular);
        course.setDuration("50hour");
        course.setLevel(CourseLevel.INTERMEDIATE);
        course.setLanguage("English");
        course.setPrice(BigDecimal.valueOf(10000));
        course.setRating(5d);
        course.setTitle("Angular");
        course.setDescription("Very intensive course");
        course.setPublishedDate(LocalDate.now());

        courseRepository.save(course);

        /*log.info("SeedData is working...");
        if (categoryRepository.count() == 0) {
            List<Category> categories = List.of(
                    new Category("Java", "/images/java.png"),
                    new Category("Angular", "/images/angular.png"),
                    new Category("C#", "/images/csharp.png"),
                    new Category("React", "/images/react.png"),
                    new Category("Spring Boot", "/images/spring-boot.png"),
                    new Category("Docker", "/images/docker.png"),
                    new Category("Swift", "/images/swift.png")
            );
            categoryRepository.saveAll(categories);
            log.info("Categories is adding..."); */
        }

    }

