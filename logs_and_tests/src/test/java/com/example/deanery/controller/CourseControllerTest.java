package com.example.deanery.controller;

import com.example.deanery.model.Course;
import com.example.deanery.service.CourseService;
import com.example.deanery.service.impl.CourseServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CourseControllerTest {
    private static final String NAME = "nameCourse";
    private static final String NAME_UPDATE = "nameUPD";
    private static final CourseService courseService = new CourseServiceImpl();

    @Test
    public void createCourse() {
        Course course = createCourse(NAME);
        Course[] courses = courseService.findAll();
        long countCourses = Arrays.stream(courses)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(course.getId()))
                .count();

        Assert.assertEquals(1, countCourses);
    }

    @Test
    public void updateCourse() {
        Course course = createCourse("nameX");
        Course course1 = new Course();

        course1.setId(course.getId());
        course1.setName(NAME_UPDATE);

        courseService.update(course1);
        Course courseUpd = courseService.findById(course.getId());

        Assert.assertEquals(NAME_UPDATE, courseUpd.getName());
    }

    @Test
    public void deleteCourseById() {
        Course course = createCourse("nameZ");

        courseService.delete(course.getId());

        Course[] courses = courseService.findAll();
        long countCourses = Arrays.stream(courses)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(course.getId()))
                .count();

        Assert.assertEquals(0, countCourses);
    }

    private Course createCourse(String name) {
        Course course = new Course();
        course.setName(name);

        courseService.create(course);

        return courseService.findById(course.getId());

    }

}