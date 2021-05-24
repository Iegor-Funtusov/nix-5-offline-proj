package com.example.deanery.dao.impl;

import com.example.deanery.dao.CourseRegisterDao;
import com.example.deanery.model.Course;
import com.example.deanery.model.CourseRegister;
import com.example.deanery.model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CourseRegisterDaoImplTest {
    private static final String FIRST_NAME = "fName";
    private static final String LAST_NAME = "lName";
    private static final String COURSE_NAME = "name";
    private static final String COURSE_NAME_UPDATE = "nameUPD";
    private static final CourseRegisterDao courseRegisterDao = new CourseRegisterDaoImpl();
    private static CourseRegister[] courseRegisterArray;

    @BeforeAll
    static void setUp(){
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setFirstName(FIRST_NAME+i);
            student.setLastName(LAST_NAME+i);

            Course course = new Course();
            course.setName(COURSE_NAME+i);

            CourseRegister courseRegister = new CourseRegister();
            courseRegister.setStudent(student);
            courseRegister.setCourse(course);

            courseRegisterDao.create(courseRegister);
        }
        courseRegisterArray = courseRegisterDao.findAll();
        long countCourses = Arrays.stream(courseRegisterArray)
                .filter(s -> s != null)
                .count();

        Assert.assertEquals(10, countCourses);
    }

    @Test
    public void create() {
        Student student = new Student();
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);

        Course course = new Course();
        course.setName(COURSE_NAME);

        CourseRegister courseRegister = new CourseRegister();
        courseRegister.setStudent(student);
        courseRegister.setCourse(course);

        courseRegisterDao.create(courseRegister);

        CourseRegister[] courseRegisters = courseRegisterDao.findAll();
        long countCourseRegisters = Arrays.stream(courseRegisters)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(courseRegister.getId()))
                .count();

        Assert.assertEquals(1, countCourseRegisters);
    }

    @Test
    public void update() {
        Course course = new Course();
        course.setName(COURSE_NAME_UPDATE);

        CourseRegister courseRegister = courseRegisterArray[0];
        courseRegister.setCourse(course);

        courseRegisterDao.update(courseRegister);
        CourseRegister courseRegisterUpd = courseRegisterDao.findById(courseRegister.getId());

        Assert.assertEquals(course, courseRegisterUpd.getCourse());
    }

    @Test
    public void delete() {
        CourseRegister courseRegister = courseRegisterArray[9];

        courseRegisterDao.delete(courseRegister.getId());

        CourseRegister[] courseRegisters = courseRegisterDao.findAll();
        long countCourses = Arrays.stream(courseRegisters)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(courseRegister.getId()))
                .count();

        Assert.assertEquals(0, countCourses);
    }

    @Test
    public void findById() {
        CourseRegister courseRegister = courseRegisterArray[5];
        CourseRegister courseRegisterFind = courseRegisterDao.findById(courseRegister.getId());

        Assert.assertNotNull(courseRegisterFind);
    }

    @Test
    public void findAll() {
        CourseRegister[] courseRegisters = courseRegisterDao.findAll();

        Assert.assertNotNull(courseRegisters);
    }
}