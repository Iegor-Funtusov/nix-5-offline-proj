package com.example.deanery.dao;

import com.example.deanery.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentDao {
    void create(Student student) throws IOException;
    void update(Student student);
    void delete(String id);
    Student findById(String id);
    Student[] findAll();
}
