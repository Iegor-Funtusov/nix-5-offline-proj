package com.nixsolutions.courses.controllers;

import com.nixsolutions.courses.services.CourseService;
import com.nixsolutions.courses.obj.Course;

import java.io.InputStreamReader;
import java.util.Arrays;
import javax.management.InstanceAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;

public class CourseController {

    private final CourseService courseService = new CourseService();
    private final StudentController studentController = new StudentController();
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private void create() throws IOException {
        try {
            System.out.println("Enter the maximum course size:");
            Course course = new Course(Integer.parseInt(reader.readLine()));
            System.out.println("Enter the course name:");
            course.setName(reader.readLine());
            if (courseService.create(course)) {
                System.out.println("Course created");
            } else {
                System.out.println("Not enough space");
            }
        } catch (NumberFormatException e) {
            System.out.println("Not a number is entered");
        } catch (InstanceAlreadyExistsException e) {
            System.out.println("A course with the same name already exists");
        }
    }

    private void read() throws IOException {
        System.out.println("Enter the name of the course you want to read:");
        System.out.println(courseService.read(reader.readLine()));
    }

    private void update() throws IOException {
        System.out.println("Enter course name you want to change:");
        Course course = courseService.read(reader.readLine());
        String name = course.getName();
        System.out.println("What to change?\n1 - New name for course\n2 - Add students");
        switch (reader.readLine()) {
            case "1":
                System.out.println("Enter new name:");
                name = reader.readLine();
                break;
            case "2":
                studentController.readConsole(course, reader);
                break;
        }
        courseService.update(course, name);
        System.out.println("Course updated");

    }

    private void delete() throws IOException {
        System.out.println("Enter course name you want to delete:");
        courseService.delete(reader.readLine());
        System.out.println("Course deleted");
    }

    private void readAll() {
        Course[] courses = courseService.readAll();
        Arrays.stream(courses).forEach(System.out::println);
    }

    public void readConsole() {
        System.out.println("What you need:" +
                "\n1 - create course" +
                "\n2 - read course" +
                "\n3 - update course(add students)" +
                "\n4 - delete course" +
                "\n5 - read all courses" +
                "\n0 - exit");
        String input;
        try {
            while ((input = reader.readLine()) != null) {
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
                    case "0":
                        System.exit(0);
                }
                System.out.println("What you need:" +
                        "\n1 - create course" +
                        "\n2 - read course" +
                        "\n3 - update course(add students)" +
                        "\n4 - delete course" +
                        "\n5 - read all courses" +
                        "\n0 - exit");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }


}
