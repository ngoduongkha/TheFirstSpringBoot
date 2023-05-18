package com.example.thefirstspringboot.course.service;

import com.example.thefirstspringboot.course.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);

    List<Course> getCourses();
}
