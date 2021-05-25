package com.example.deanery.controller;

import com.example.deanery.model.Course;
import com.example.deanery.model.CourseRegister;
import com.example.deanery.model.Student;
import com.example.deanery.service.CourseRegisterService;
import com.example.deanery.service.CourseService;
import com.example.deanery.service.StudentService;
import com.example.deanery.service.impl.CourseRegisterServiceImpl;
import com.example.deanery.service.impl.CourseServiceImpl;
import com.example.deanery.service.impl.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class CourseRegisterController {
    private final BufferedReader reader;
    private final CourseService courseService = new CourseServiceImpl();
    private final StudentService studentService = new StudentServiceImpl();
    private final CourseRegisterService courseRegisterService = new CourseRegisterServiceImpl();

    public CourseRegisterController(BufferedReader reader) {
        this.reader = reader;
    }

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - insert Student to Course" + "\n 2 - update CourseRegister"
                    + "\n 3 - delete CourseRegister" + "\n 4 - get all CourseRegisters" + "\n 5 - get CourseRegister by Id"
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
                printAllStudentsAndCourses();
                createCourseRegister();
                exec();
            }
            break;
            case "2":{
                printAllStudentsAndCourses();
                updateCourseRegister();
                exec();
            }
            break;
            case "3":{
                deleteCourseRegisterById();
                exec();
            }
            break;
            case "4":{
                getAllCourseRegistersAndPrint();
                exec();
            }
            break;
            case "5":{
                getCourseRegisterByIdAndPrint();
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

    private void createCourseRegister() throws IOException {
        System.out.println("For registration student to course, enter student and course");
        System.out.println("Enter student id: ");
        String studentId = reader.readLine();
        System.out.println("Enter course id");
        String courseId = reader.readLine();

        Student student = studentService.findById(studentId);
        Course course = courseService.findById(courseId);

        CourseRegister courseRegister = new CourseRegister();
        courseRegister.setStudent(student);
        courseRegister.setCourse(course);

        courseRegisterService.create(courseRegister);
    }

    private void updateCourseRegister() throws IOException {
        System.out.println("Enter Id of courseRegister which you want to change: ");
        String courseRegisterId = reader.readLine();
        CourseRegister courseRegister = courseRegisterService.findById(courseRegisterId);

        setFieldToUpdate(courseRegister);

        System.out.println(courseRegister);

        courseRegisterService.update(courseRegister);
    }

    private void setFieldToUpdate(CourseRegister courseRegister) throws IOException {
        System.out.println("Enter student ID: ");
        String studentId = reader.readLine();
        System.out.println("Enter course ID: ");
        String courseId = reader.readLine();
        if(!studentId.isBlank()){
            courseRegister.setStudent(studentService.findById(studentId));
        }
        if(!courseId.isBlank()){
            courseRegister.setCourse(courseService.findById(courseId));
        }
    }

    private void deleteCourseRegisterById() throws IOException {
        System.out.println("Enter Id of courseRegister which you want to Delete: ");
        String id = reader.readLine();
        courseRegisterService.delete(id);
    }

    private void getAllCourseRegistersAndPrint() {
        CourseRegister[] courseRegisters = courseRegisterService.findAll();
        System.out.println(Arrays.toString(courseRegisters));
    }

    private void getCourseRegisterByIdAndPrint() throws IOException {
        System.out.println("Enter Id of courseRegister: ");
        String id = reader.readLine();
        CourseRegister courseRegister = courseRegisterService.findById(id);
        System.out.println(courseRegister);

    }

    private void printAllStudentsAndCourses(){
        Student[] students = studentService.findAll();
        Course[] courses = courseService.findAll();
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(courses));
    }
}
