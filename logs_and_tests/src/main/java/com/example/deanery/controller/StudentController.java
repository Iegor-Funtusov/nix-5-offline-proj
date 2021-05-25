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

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - insert Student" + "\n 2 - update Student"
                    + "\n 3 - delete Student" + "\n 4 - get all Students" + "\n 5 - get Student by Id"
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
                createStudent();
                exec();
            }
            break;
            case "2":{
                updateStudent();
                exec();
            }
            break;
            case "3":{
                deleteStudentById();
                exec();
            }
            break;
            case "4":{
                getAllStudentsAndPrint();
                exec();
            }
            break;
            case "5":{
                getStudentByIdAndPrint();
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

    private void createStudent() throws IOException {
        Student student = new Student();
        System.out.println("Enter first name of student: ");
        student.setFirstName(reader.readLine());
        System.out.println("Enter last name of student: ");
        student.setLastName(reader.readLine());
        studentService.create(student);
    }

    private void updateStudent() throws IOException {
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

    private void deleteStudentById() throws IOException {
        System.out.println("Enter Id of student which you want to Delete: ");
        String id = reader.readLine();
        studentService.delete(id);
    }

    private void getAllStudentsAndPrint() {
        Student[] students = studentService.findAll();
        System.out.println(Arrays.toString(students));
    }

    private void getStudentByIdAndPrint() throws IOException {
        System.out.println("Enter Id of student: ");
        String id = reader.readLine();
        Student student = studentService.findById(id);
        System.out.println(student);

    }
}
