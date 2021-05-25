package com.example.deanery.ui;

import com.example.deanery.controller.CourseController;
import com.example.deanery.controller.CourseRegisterController;
import com.example.deanery.controller.StudentController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenuUI {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - Student manager" + "\n 2 - Course manager"
                    + "\n 3 - Registration student to course" + "\n 0 - exit";
            System.out.println(helpStr);
            setAction(reader.readLine());
        } catch (IOException ex) {
            System.out.println("IOException from exec() reader: " + ex.getMessage());
        }
    }

    private void setAction(String read) throws IOException {
        switch (read) {
            case "1":{
                studentMenu();
                exec();
            }
            break;
            case "2":{
                courseMenu();
                exec();
            }
            break;
            case "3":{
                courseRegisterMenu();
                exec();
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

    private void studentMenu()  {
        StudentUI studentUI = new StudentUI(reader);
        studentUI.exec();
    }

    private void courseMenu() {
        CourseUI courseUI = new CourseUI(reader);
        courseUI.exec();
    }

    private void courseRegisterMenu() {
        CourseRegisterUI courseRegisterUI = new CourseRegisterUI(reader);
        courseRegisterUI.exec();
    }
}
