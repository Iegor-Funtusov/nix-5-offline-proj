package com.example.deanery.ui;

import com.example.deanery.controller.StudentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class StudentUI {
    private final BufferedReader reader;
    private final StudentController controller;
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public StudentUI(BufferedReader reader) {
        this.reader = reader;
        controller = new StudentController(reader);
    }

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - insert Student" + "\n 2 - update Student"
                    + "\n 3 - delete Student" + "\n 4 - get all Students" + "\n 5 - get Student by Id"
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
                controller.createStudent();
                exec();
            }
            break;
            case "2":{
                controller.updateStudent();
                exec();
            }
            break;
            case "3":{
                controller.deleteStudentById();
                exec();
            }
            break;
            case "4":{
                controller.getAllStudentsAndPrint();
                exec();
            }
            break;
            case "5":{
                controller.getStudentByIdAndPrint();
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
