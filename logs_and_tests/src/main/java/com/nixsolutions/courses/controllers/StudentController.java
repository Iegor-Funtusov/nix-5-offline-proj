package com.nixsolutions.courses.controllers;

import com.nixsolutions.courses.obj.Course;
import com.nixsolutions.courses.obj.Student;
import com.nixsolutions.courses.services.StudentService;

import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;

public class StudentController {

    private final StudentService studentService = new StudentService();
    BufferedReader reader;
    private Course course;

    private void create() throws IOException {
        try {
            Student student = new Student();
            System.out.println("Enter name of the student:");
            student.setName(reader.readLine());
            System.out.println("Enter age:");
            student.setAge(Integer.parseInt(reader.readLine()));
            if (studentService.create(student, course)) {
                System.out.println("Student created:"+student);
            } else {
                System.out.println("Not enough space");
            }
        } catch (NumberFormatException e) {
            System.out.println("Not a number is entered");
        }
    }

    private void read() throws IOException {
        System.out.println("Enter ID of student you want to read:");
        System.out.println(studentService.read(reader.readLine(), course));
    }

    private void update() throws IOException {
        System.out.println("Enter ID of student you want to change:");
        Student student = studentService.read(reader.readLine(), course);
        System.out.println("What's need to update?\n1 - Name\n2 - Age\n3 - Course");
        switch (reader.readLine()) {
            case "1":
                System.out.println("Enter new name:");
                student.setName(reader.readLine());
                break;
            case "2":
                System.out.println("Enter new age:");
                student.setAge(Integer.parseInt(reader.readLine()));
                break;
            case "3" :
                System.out.println("Enter new name of course:");
                student.setCourseName(reader.readLine());
                break;
        }
        if (studentService.update(student, course)) {
            System.out.println("Student updated");
        } else {
            System.out.println("Student was not updated");
        }
    }

    private void delete() throws IOException {
        System.out.println("Enter id of student you want to delete:");
        if (studentService.delete(reader.readLine(), course)) {
            System.out.println("Student deleted");
        } else {
            System.out.println("Student was not deleted");
        }
    }

    private void readAll() {
        Student[] students = studentService.readAll(course);
        Arrays.stream(students).forEach(System.out::println);
    }

    public void readConsole(Course course, BufferedReader reader) {
        this.reader = reader;
        this.course = course;
        System.out.println("What you need:\n1 - create student\n2 - read by id student\n3 - update student\n4 - delete student\n5 - read all students\n0 - return");
        String input;
        try {
            while (!(input = reader.readLine()).equals("0")) {
                switch (input) {
                    case "1":
                        create();
                        break;
                    case "2":
                        read();
                        break;
                    case "3":
                        update();
                        break;
                    case "4":
                        delete();
                        break;
                    case "5":
                        readAll();
                        break;
                }
                System.out.println("What you need:\n1 - create student\n2 - read by id student\n3 - update student\n4 - delete student\n5 - read all students\n0 - return");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
