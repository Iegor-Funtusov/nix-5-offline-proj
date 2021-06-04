package com.example.deanery.service.impl;

import com.example.deanery.model.Course;
import com.example.deanery.model.CourseRegister;
import com.example.deanery.model.Student;
import com.example.deanery.service.CourseRegisterService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CourseRegisterServiceImplTest {
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String COURSE_NAME = "name";
    private static final String COURSE_NAME_UPDATE = "nameUPD";
    private static final CourseRegisterService courseRegisterService = new CourseRegisterServiceImpl();

    @Test
    public void create() {
        CourseRegister courseRegister = createCourseRegister();
        CourseRegister[] courseRegisters = courseRegisterService.findAll();
        long countStudents = Arrays.stream(courseRegisters)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(courseRegister.getId()))
                .count();

        Assert.assertEquals(1, countStudents);
    }

    @Test
    public void create_ShouldNotThrowNullPointer(){
        CourseRegister courseRegister = null;
        courseRegisterService.create(courseRegister);
    }

    @Test
    public void update() {
        Course course = new Course();
        course.setName(COURSE_NAME_UPDATE);

        CourseRegister courseRegister = createCourseRegister();
        CourseRegister courseRegister1 = new CourseRegister();

        courseRegister1.setId(courseRegister.getId());
        courseRegister1.setCourse(course);
        courseRegister1.setStudent(new Student());

        courseRegisterService.update(courseRegister1);
        CourseRegister courseRegisterUpd = courseRegisterService.findById(courseRegister.getId());

        Assert.assertEquals(course, courseRegisterUpd.getCourse());
    }

    @Test
    public void delete() {
        CourseRegister courseReg = createCourseRegister();

        courseRegisterService.delete(courseReg.getId());
        CourseRegister[] courseRegisters = courseRegisterService.findAll();
        long countCourses = Arrays.stream(courseRegisters)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(courseReg.getId()))
                .count();

        Assert.assertEquals(0, countCourses);
    }

    @Test
    public void notCreateWithoutCourse(){
        CourseRegister courseRegister = new CourseRegister();
        courseRegister.setStudent(new Student());

        courseRegisterService.create(courseRegister);
        CourseRegister courseRegister1 = courseRegisterService.findById(courseRegister.getId());
        Assert.assertNull(courseRegister1);
    }

    @Test
    public void notCreateWithoutStudent(){
        CourseRegister courseRegister = new CourseRegister();
        courseRegister.setCourse(new Course());

        courseRegisterService.create(courseRegister);
        CourseRegister courseRegister1 = courseRegisterService.findById(courseRegister.getId());

        Assert.assertNull(courseRegister1);
    }

    @Test
    public void update_ShouldNotThrowNullPointer(){
        CourseRegister courseRegister = null;
        courseRegisterService.update(courseRegister);
    }

    private CourseRegister createCourseRegister(){
        Student student = new Student();
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);

        Course course = new Course();
        course.setName(COURSE_NAME);

        CourseRegister courseRegister = new CourseRegister();
        courseRegister.setStudent(student);
        courseRegister.setCourse(course);

        courseRegisterService.create(courseRegister);

        return courseRegisterService.findById(courseRegister.getId());
    }

}