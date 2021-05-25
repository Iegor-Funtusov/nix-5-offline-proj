package com.example.deanery.controller;

import com.example.deanery.model.Student;
import com.example.deanery.service.StudentService;
import com.example.deanery.service.impl.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class StudentController {
    private final BufferedReader reader;
    private final StudentService studentService = new StudentServiceImpl();

    public StudentController(BufferedReader reader) {
        this.reader = reader;
    }

    public void createStudent() throws IOException {
        Student student = new Student();
        System.out.println("Enter first name of student: ");
        student.setFirstName(reader.readLine());
        System.out.println("Enter last name of student: ");
        student.setLastName(reader.readLine());
        studentService.create(student);
    }

    public void updateStudent() throws IOException {
        System.out.println("Enter Id of student which you want to change: ");
        String studentId = reader.readLine();
        Student student = studentService.findById(studentId);

        setStudentFieldToUpdate(student);

        studentService.update(student);
    }

    private void setStudentFieldToUpdate(Student student) throws IOException {
        System.out.println("Enter first name of user: ");
        String firstName = reader.readLine();
        System.out.println("Enter last name of user: ");
        String lastName = reader.readLine();
        if(!firstName.isBlank()){
            student.setFirstName(firstName);
        }
        if(!lastName.isBlank()){
            student.setLastName(lastName);
        }
    }

    public void deleteStudentById() throws IOException {
        System.out.println("Enter Id of student which you want to Delete: ");
        String id = reader.readLine();
        studentService.delete(id);
    }

    public void getAllStudentsAndPrint() {
        Student[] students = studentService.findAll();
        System.out.println(Arrays.toString(students));
    }

    public void getStudentByIdAndPrint() throws IOException {
        System.out.println("Enter Id of student: ");
        String id = reader.readLine();
        Student student = studentService.findById(id);
        System.out.println(student);

    }
}
