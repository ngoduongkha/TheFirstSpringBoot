package com.example.thefirstspringboot.course.repository;

import com.example.thefirstspringboot.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
