package com.example.thefirstspringboot.course.service;

import com.example.thefirstspringboot.course.entity.Course;
import com.example.thefirstspringboot.course.repository.CourseRepository;
import com.example.thefirstspringboot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    @Override
    public Course createCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> getCourses() {
        return repository.findAll();
    }
}
