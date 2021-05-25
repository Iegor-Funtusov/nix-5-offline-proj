package com.example.deanery.service.impl;

import com.example.deanery.model.Student;
import com.example.deanery.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StudentServiceImplTest {
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String LAST_NAME_UPDATE = "last_nameUPD";
    private static final StudentService studentService = new StudentServiceImpl();

    @Test
    public void create() {
        Student student = createStudent();
        Student[] students = studentService.findAll();
        long countStudents = Arrays.stream(students)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(student.getId()))
                .count();

        Assert.assertEquals(1, countStudents);
    }

    @Test
    public void create_ShouldNotThrowNullPointer(){
        Student student = null;
        studentService.create(student);
    }

    @Test
    public void update() {
        Student student = createStudent();
        Student student1 = new Student();
        student1.setId(student.getId());
        student1.setLastName(LAST_NAME_UPDATE);

        studentService.update(student1);
        Student studentUpd = studentService.findById(student.getId());

        Assert.assertEquals(LAST_NAME_UPDATE, studentUpd.getLastName());
    }

    @Test
    public void update_ShouldNotThrowNullPointer(){
        Student student = null;
        studentService.update(student);
    }

    private Student createStudent(){
        Student student = new Student();
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);

        studentService.create(student);

        return studentService.findById(student.getId());
    }

}