package com.example.deanery.dao.impl;

import com.example.deanery.dao.CourseDao;
import com.example.deanery.model.Course;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CourseDaoImplTest {
    private static final String NAME = "name";
    private static final String NAME_UPDATE = "nameUPD";
    private static final CourseDao courseDao = new CourseDaoImpl();
    private static Course[] courseArray;

    @BeforeAll
    static void setUp(){
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setName(NAME+i);
            courseDao.create(course);
        }
        courseArray = courseDao.findAll();
        long countCourses = Arrays.stream(courseArray)
                .filter(s -> s != null)
                .count();

        Assert.assertEquals(10, countCourses);
    }

    @Test
    public void create() {
        Course course = new Course();
        course.setName(NAME);

        courseDao.create(course);
        Course[] courses = courseDao.findAll();
        long countCourses = Arrays.stream(courses)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(course.getId()))
                .count();

        Assert.assertEquals(1, countCourses);
    }

    @Test
    public void update() {
        Course course = courseArray[0];
        Course course1 = new Course();

        course1.setId(course.getId());
        course1.setName(NAME_UPDATE);

        courseDao.update(course1);
        Course courseUpd = courseDao.findById(course.getId());

        Assert.assertEquals(NAME_UPDATE, courseUpd.getName());
    }

    @Test
    public void delete() {
        Course course = courseArray[9];

        courseDao.delete(course.getId());

        Course[] courses = courseDao.findAll();
        long countCourses = Arrays.stream(courses)
                .filter(s -> s != null)
                .filter(s -> s.getId().equals(course.getId()))
                .count();

        Assert.assertEquals(0, countCourses);
    }

    @Test
    public void findById() {
        Course course = courseArray[5];
        Course courseFind = courseDao.findById(course.getId());
        Assert.assertNotNull(courseFind);
    }

    @Test
    public void findByName(){
        String name = courseArray[2].getName();
        Course course1 = courseDao.findByName(name);

        Assert.assertEquals(name, course1.getName());
    }
    @Test
    public void findAll() {
        Course[] courses = courseDao.findAll();

        Assert.assertNotNull(courses);
    }
}