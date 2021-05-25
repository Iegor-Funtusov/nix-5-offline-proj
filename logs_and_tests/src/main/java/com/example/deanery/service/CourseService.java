package com.example.deanery.service;

import com.example.deanery.model.Course;

public interface CourseService {
    void create(Course course);
    void update(Course course);
    void delete(String id);
    Course findById(String id);
    Course findByName(String name);
    Course[] findAll();
}
