package com.example.deanery.service;

import com.example.deanery.model.Student;

public interface StudentService {
    void create(Student student);
    void update(Student student);
    void delete(String id);
    Student findById(String id);
    Student[] findAll();
}
