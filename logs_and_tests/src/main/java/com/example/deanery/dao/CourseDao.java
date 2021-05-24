package com.example.deanery.dao;

import com.example.deanery.model.Course;

public interface CourseDao {
    void create(Course course);
    void update(Course course);
    void delete(String id);
    Course findById(String id);
    Course[] findAll();
}
