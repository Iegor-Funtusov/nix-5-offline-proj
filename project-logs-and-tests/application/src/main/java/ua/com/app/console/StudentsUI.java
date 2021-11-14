package ua.com.app.console;

import ua.com.app.courseDAO.CourseInputImpl;
import ua.com.app.studentDAO.StudentInputImpl;

import java.io.IOException;

public class StudentsUI {
    public static final StudentInputImpl studentImpl = new StudentInputImpl();

    public void run() throws IOException {
        message();
        switch (ConsoleApp.inputConstant()) {
            case "1": {
                studentImpl.create();
                break;
            }
            case "2": {
                studentImpl.read();
                break;
            }
            case "3": {
                studentImpl.update();
                break;
            }
            case "4": {
                studentImpl.delete();
                break;
            }
            case "5": {
                StudentInputImpl.readAll();
                break;
            }
            case "6": {
                studentImpl.addCourse();
                break;
            }
            case "7": {
                studentImpl.deleteCourse();
                break;
            }
            case "8": {
                CourseInputImpl.readAll();
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
        System.out.println("Student editor\n" +
                "1 - Create student\n" +
                "2 - Read student by Id\n" +
                "3 - Update student by Id\n" +
                "4 - Delete student by Id\n" +
                "5 - Read all students\n" +
                "6 - Add a course by id for student\n" +
                "7 - Delete a course by id for student\n" +
                "8 - Get all available courses\n" +
                "9 - Go back\n" +
                "0 - Exit");
    }
}
