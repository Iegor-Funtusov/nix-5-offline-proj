package ua.com.app.console;

import ua.com.app.courseDAO.CourseInputImpl;

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
                System.out.println(courseImpl.readAll());
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
                "1 - Create\n" +
                "2 - Read by Id\n" +
                "3 - Update by Id\n" +
                "4 - Delete by Id\n" +
                "5 - Read all courses\n" +
                "9 - Go back\n" +
                "0 - Exit");
    }
}
