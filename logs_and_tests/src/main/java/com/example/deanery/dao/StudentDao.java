package com.example.deanery.dao;

import com.example.deanery.model.Student;

public interface StudentDao {
    void create(Student student);
    void update(Student student);
    void delete(String id);
    Student findById(String id);
    Student[] findAll();
}
