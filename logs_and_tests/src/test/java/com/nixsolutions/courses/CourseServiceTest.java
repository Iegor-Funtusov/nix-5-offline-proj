package com.nixsolutions.courses;

import com.nixsolutions.courses.services.CourseService;
import org.junit.jupiter.api.*;
import com.nixsolutions.courses.obj.Course;

import javax.management.InstanceAlreadyExistsException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseServiceTest {

    private final static CourseService COURSE_SERVICE = new CourseService();
    private final static int GROUP_SIZE = 5;

    @Test
    @Order(1)
    public void create()  {
        try {
            Course course = new Course(GROUP_SIZE);
            course.setName("test");
            COURSE_SERVICE.create(course);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        }
        Course createdCourse = COURSE_SERVICE.read("test");
        Assertions.assertNotNull(createdCourse);
    }

    @Test
    @Order(2)
    public void createDuplicate() {
        Course course = new Course(GROUP_SIZE);
        course.setName("test");
        Assertions.assertThrows(InstanceAlreadyExistsException.class, () -> COURSE_SERVICE.create(course));
    }

    @Test
    @Order(3)
    public void readAll() {
        Course[] courses = COURSE_SERVICE.readAll();

        Assertions.assertTrue(courses.length != 0);
    }

    @Test
    @Order(4)
    public void update() {
        Course course = COURSE_SERVICE.read("test");
        COURSE_SERVICE.update(course, "update");

        Assertions.assertThrows(RuntimeException.class, () -> COURSE_SERVICE.read("test"));
    }

    @Test
    @Order(5)
    public void delete() {
        COURSE_SERVICE.delete("update");

        Assertions.assertThrows(RuntimeException.class, () -> COURSE_SERVICE.read("update"));
    }
}
