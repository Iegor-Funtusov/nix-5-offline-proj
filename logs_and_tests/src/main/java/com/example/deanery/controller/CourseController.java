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

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - insert Course" + "\n 2 - update Course"
                    + "\n 3 - delete Course" + "\n 4 - get all Courses" + "\n 5 - get Course by Id"
                    + "\n 6 - back to menu" + "\n 0 - exit";
            System.out.println(helpStr);
            setAction(reader.readLine());
        } catch (IOException ex) {
            System.out.println("IOException from exec() reader: " + ex.getMessage());
        }
    }

    private void setAction(String read) throws IOException {
        switch (read) {
            case "1":{
                createCourse();
                exec();
            }
            break;
            case "2":{
                updateCourse();
                exec();
            }
            break;
            case "3":{
                deleteCourseById();
                exec();
            }
            break;
            case "4":{
                getAllCoursesAndPrint();
                exec();
            }
            break;
            case "5":{
                getCourseByIdAndPrint();
                exec();
            }
            break;
            case "6":{
            }
            break;
            case "0":{
                System.exit(0);
            }
            break;
            default:{
                System.out.println("Enter correct operation!");
                exec();
            }
        }
    }

    private void createCourse() throws IOException {
        Course course = new Course();
        System.out.println("Enter name of course: ");
        course.setName(reader.readLine());
        courseService.create(course);
    }

    private void updateCourse() throws IOException {
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

    private void deleteCourseById() throws IOException {
        System.out.println("Enter Id of course which you want to Delete: ");
        String id = reader.readLine();
        courseService.delete(id);
    }

    private void getAllCoursesAndPrint() {
        Course[] courses = courseService.findAll();
        System.out.println(Arrays.toString(courses));
    }

    private void getCourseByIdAndPrint() throws IOException {
        System.out.println("Enter Id of course: ");
        String id = reader.readLine();
        Course course = courseService.findById(id);
        System.out.println(course);

    }
}
