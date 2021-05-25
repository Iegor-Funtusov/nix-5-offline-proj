package com.example.deanery.ui;

import com.example.deanery.controller.CourseController;

import java.io.BufferedReader;
import java.io.IOException;

public class CourseUI {
    private final BufferedReader reader;
    private final CourseController controller;

    public CourseUI(BufferedReader reader) {
        this.reader = reader;
        controller = new CourseController(reader);
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
                controller.createCourse();
                exec();
            }
            break;
            case "2":{
                controller.updateCourse();
                exec();
            }
            break;
            case "3":{
                controller.deleteCourseById();
                exec();
            }
            break;
            case "4":{
                controller.getAllCoursesAndPrint();
                exec();
            }
            break;
            case "5":{
                controller.getCourseByIdAndPrint();
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
