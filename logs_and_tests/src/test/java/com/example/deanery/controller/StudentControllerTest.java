package com.example.deanery.controller;

import com.example.deanery.model.Student;
import com.example.deanery.service.StudentService;
import com.example.deanery.service.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StudentControllerTest {
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String LAST_NAME_UPDATE = "last_nameUPD";
    private static final StudentService studentService = new StudentServiceImpl();
    private static Student[] studentArray;

    @BeforeAll
    static void setUp(){
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setFirstName(FIRST_NAME+i);
            student.setLastName(LAST_NAME+i);
            studentService.create(student);
        }
        studentArray = studentService.findAll();
        long countStudents = Arrays.stream(studentArray)
                .filter(s -> s != null)
                .count();

        Assert.assertEquals(5, countStudents);
    }

    @Test
    public void createStudent() {
        Student student = new Student();
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);

        studentService.create(student);
        Student[] students = studentService.findAll();
        long countStudents = Arrays.stream(students)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(student.getId()))
                .count();

        Assert.assertEquals(1, countStudents);
    }

    @Test
    public void updateStudent() {
        Student student = studentArray[0];
        Student student1 = new Student();
        student1.setId(student.getId());
        student1.setLastName(LAST_NAME_UPDATE);

        studentService.update(student1);
        Student studentUpd = studentService.findById(student.getId());

        Assert.assertEquals(LAST_NAME_UPDATE, studentUpd.getLastName());
    }

    @Test
    public void deleteStudentById() {
        Student student = studentArray[1];

        studentService.delete(student.getId());

        Student[] students = studentService.findAll();
        long countStudents = Arrays.stream(students)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(student.getId()))
                .count();

        Assert.assertEquals(0, countStudents);
    }
}