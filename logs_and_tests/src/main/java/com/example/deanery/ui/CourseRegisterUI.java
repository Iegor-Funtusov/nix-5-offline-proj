package com.example.deanery.ui;

import com.example.deanery.controller.CourseRegisterController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class CourseRegisterUI {
    private final BufferedReader reader;
    private final CourseRegisterController controller;
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

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
            LOGGER_ERROR.error(ex.getMessage());
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
