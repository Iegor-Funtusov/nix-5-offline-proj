package ua.com.app.console;

import ua.com.app.courseDAO.CourseInputImpl;
import ua.com.app.studentDAO.StudentInputImpl;

import java.io.IOException;

public class CoursesUI {
    public static final CourseInputImpl courseImpl = new CourseInputImpl();

    public void run() throws IOException {
        message();
        switch (ConsoleApp.inputConstant()) {
            case "1": {
                courseImpl.create();
                break;
            }
            case "2": {
                courseImpl.read();
                break;
            }
            case "3": {
                courseImpl.update();
                break;
            }
            case "4": {
                courseImpl.delete();
                break;
            }
            case "5": {
                CourseInputImpl.readAll();
                break;
            }
            case "6":{
                courseImpl.addStudent();
                break;
            }
            case "7":{
                courseImpl.deleteStudent();
                break;
            }
            case "8":{
                StudentInputImpl.readAll();
                break;
            }
            case "9": {
                ConsoleApp.main(null);
                break;
            }
            case "0": {
                System.exit(0);
                break;
            }
        }
        run();
    }

    private void message() {
        System.out.println("Courses editor\n" +
                "1 - Create Course\n" +
                "2 - Read Course by Id\n" +
                "3 - Update Course by Id\n" +
                "4 - Delete Course by Id\n" +
                "5 - Read all courses\n" +
                "6 - Add a student by id for course\n" +
                "7 - Delete a student by id for course\n" +
                "8 - Get all available students\n" +
                "9 - Go back\n" +
                "0 - Exit");
    }
}
