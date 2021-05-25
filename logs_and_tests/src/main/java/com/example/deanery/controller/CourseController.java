package com.example.deanery.controller;

import com.example.deanery.model.Course;
import com.example.deanery.service.CourseService;
import com.example.deanery.service.impl.CourseServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class CourseController {
    private final BufferedReader reader;
    private final CourseService courseService = new CourseServiceImpl();

    public CourseController(BufferedReader reader) {
        this.reader = reader;
    }

    public void createCourse() throws IOException {
        Course course = new Course();
        System.out.println("Enter name of course: ");
        course.setName(reader.readLine());
        courseService.create(course);
    }

    public void updateCourse() throws IOException {
        System.out.println("Enter Id of course which you want to change: ");
        String courseId = reader.readLine();
        Course course = courseService.findById(courseId);
        System.out.println("Enter name of course: ");
        String name = reader.readLine();
        if(!name.isBlank()){
            course.setName(name);
        }
        courseService.update(course);
    }

    public void deleteCourseById() throws IOException {
        System.out.println("Enter Id of course which you want to Delete: ");
        String id = reader.readLine();
        courseService.delete(id);
    }

    public void getAllCoursesAndPrint() {
        Course[] courses = courseService.findAll();
        System.out.println(Arrays.toString(courses));
    }

    public void getCourseByIdAndPrint() throws IOException {
        System.out.println("Enter Id of course: ");
        String id = reader.readLine();
        Course course = courseService.findById(id);
        System.out.println(course);

    }
}
