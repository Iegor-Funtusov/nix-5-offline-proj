package com.example.deanery.service.impl;

import com.example.deanery.model.Course;
import com.example.deanery.service.CourseService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CourseServiceImplTest {
    private static final String NAME = "name_course";
    private static final String NAME_UPDATE = "nameUPD";
    private static final CourseService courseService = new CourseServiceImpl();

    @Test
    public void create() {
        Course course = createCourse(NAME);
        Course[] courses = courseService.findAll();
        long countCourses = Arrays.stream(courses)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(course.getId()))
                .count();

        Assert.assertEquals(1, countCourses);
    }

    @Test
    public void create_ShouldNotThrowNullPointer() {
        Course course = null;
        courseService.create(course);
    }

    @Test
    public void update() {
        Course course = createCourse("name11");
        Course course1 = new Course();

        course1.setId(course.getId());
        course1.setName(NAME_UPDATE);

        courseService.update(course1);
        Course courseUpd = courseService.findById(course.getId());

        Assert.assertEquals(NAME_UPDATE, courseUpd.getName());
    }

    @Test
    public void update_ShouldNotThrowNullPointer() {
        Course course = null;
        courseService.update(course);
    }

    @Test
    public void createWithSameName(){
        createCourse("name2");
        Course course1 = createCourse("name2");
        Assert.assertNull(course1);
    }

    @Test
    public void findByName(){
        String name = "name3";
        createCourse(name);

        Course course1 = courseService.findByName(name);

        Assert.assertEquals(name, course1.getName());
    }

    private Course createCourse(String name) {
        Course course = new Course();
        course.setName(name);

        courseService.create(course);

        return courseService.findById(course.getId());

    }
}