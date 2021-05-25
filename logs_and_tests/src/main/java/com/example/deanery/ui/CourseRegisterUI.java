package com.example.deanery.ui;

import com.example.deanery.controller.CourseRegisterController;
import com.example.deanery.service.CourseRegisterService;
import com.example.deanery.service.CourseService;
import com.example.deanery.service.StudentService;
import com.example.deanery.service.impl.CourseRegisterServiceImpl;
import com.example.deanery.service.impl.CourseServiceImpl;
import com.example.deanery.service.impl.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class CourseRegisterUI {
    private final BufferedReader reader;
    private final CourseRegisterController controller;

    public CourseRegisterUI(BufferedReader reader) {
        this.reader = reader;
        controller = new CourseRegisterController(reader);
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
                controller.printAllStudentsAndCourses();
                controller.createCourseRegister();
                exec();
            }
            break;
            case "2":{
                controller.printAllStudentsAndCourses();
                controller.updateCourseRegister();
                exec();
            }
            break;
            case "3":{
                controller.deleteCourseRegisterById();
                exec();
            }
            break;
            case "4":{
                controller.getAllCourseRegistersAndPrint();
                exec();
            }
            break;
            case "5":{
                controller.getCourseRegisterByIdAndPrint();
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
}
