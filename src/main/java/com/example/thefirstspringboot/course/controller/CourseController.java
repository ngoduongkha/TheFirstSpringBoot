package com.example.thefirstspringboot.course.controller;

import com.example.thefirstspringboot.common.controller.BaseController;
import com.example.thefirstspringboot.course.entity.Course;
import com.example.thefirstspringboot.course.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@Tag(name = "Course", description = "The Course API")
@RequiredArgsConstructor
public class CourseController extends BaseController {
    private final CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course courseName) {
        return courseService.createCourse(courseName);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getCourses();
    }
}
