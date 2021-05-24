package com.example.deanery.dao;

import com.example.deanery.model.CourseRegister;

public interface CourseRegisterDao {
    void create(CourseRegister courseRegister);
    void update(CourseRegister courseRegister);
    void delete(String id);
    CourseRegister findById(String id);
    CourseRegister[] findAll();
}