package com.example.deanery.service;

import com.example.deanery.model.CourseRegister;

public interface CourseRegisterService {
    void create(CourseRegister courseRegister);
    void update(CourseRegister courseRegister);
    void delete(String id);
    CourseRegister findById(String id);
    CourseRegister[] findAll();
}
