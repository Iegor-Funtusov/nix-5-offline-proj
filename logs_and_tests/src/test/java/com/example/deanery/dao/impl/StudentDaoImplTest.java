package com.example.deanery.dao.impl;

import com.example.deanery.dao.StudentDao;
import com.example.deanery.model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StudentDaoImplTest {
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String LAST_NAME_UPDATE = "last_nameUPD";
    private static final StudentDao studentDao = new StudentDaoImpl();
    private static Student[] studentArray;

    @BeforeAll
    static void setUp(){
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setFirstName(FIRST_NAME+i);
            student.setLastName(LAST_NAME+i);
            studentDao.create(student);
        }
        studentArray = studentDao.findAll();
        long countStudents = Arrays.stream(studentArray)
                .filter(s -> s != null)
                .count();

        Assert.assertEquals(10, countStudents);
    }

    @Test
    public void create() {
        Student student = new Student();
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);

        studentDao.create(student);
        Student[] students = studentDao.findAll();
        long countStudents = Arrays.stream(students)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(student.getId()))
                .count();

        Assert.assertEquals(1, countStudents);
    }

    @Test
    public void update() {
        Student student = studentArray[0];
        Student student1 = new Student();
        student1.setId(student.getId());
        student1.setLastName(LAST_NAME_UPDATE);

        studentDao.update(student1);
        Student studentUpd = studentDao.findById(student.getId());

        Assert.assertEquals(LAST_NAME_UPDATE, studentUpd.getLastName());
    }

    @Test
    public void delete() {
        Student student = studentArray[9];

        studentDao.delete(student.getId());

        Student[] students = studentDao.findAll();
        long countStudents = Arrays.stream(students)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(student.getId()))
                .count();

        Assert.assertEquals(0, countStudents);
    }

    @Test
    public void findById() {
        Student student = studentArray[5];
        Student studentFind = studentDao.findById(student.getId());
        Assert.assertNotNull(studentFind);
    }

    @Test
    public void findAll() {
        Student[] students = studentDao.findAll();

        Assert.assertNotNull(students);
    }
}