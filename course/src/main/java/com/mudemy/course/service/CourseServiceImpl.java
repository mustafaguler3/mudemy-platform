package com.mudemy.course.service;

import com.mudemy.course.dto.CourseDto;
import com.mudemy.course.model.Course;
import com.mudemy.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseDto> getCourses() {
        List<Course> courses = courseRepository.findAll();

        if (courses.isEmpty()) {
            log.error("No courses");
            return List.of();
        }

        return courses.stream().map(this::toCourseDto).toList();
    }

    private CourseDto toCourseDto(Course course){
        CourseDto courseDto = new CourseDto();

        courseDto.setTitle(course.getTitle());
        courseDto.setThumbnailUrl(course.getThumbnailUrl());
        courseDto.setPublishedDate(course.getPublishedDate());
        courseDto.setDuration(course.getDuration());
        courseDto.setLanguage(course.getLanguage());
        courseDto.setRating(course.getRating());
        courseDto.setPrice(course.getPrice());

        return courseDto;
    }
}

























