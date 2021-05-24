package com.example.deanery.service;

import com.example.deanery.model.Course;
import com.example.deanery.model.Student;

public interface CourseService {
    void create(Course course);
    void update(Course course);
    void delete(String id);
    Course findById(String id);
    Course findByName(String name);
    Course[] findAll();
}
