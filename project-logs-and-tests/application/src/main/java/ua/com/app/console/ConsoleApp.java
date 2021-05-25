package ua.com.app.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleApp {
    public static final BufferedReader bufferedReader;
    private static final String REGEX_NUMBER = "^[0-9]$";

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        ConsoleApp consoleApp = new ConsoleApp();
        consoleApp.run();
    }

    public void run() throws IOException {
    startMessage();
    switch (inputConstant()){
        case "1":{
            CoursesUI coursesUI = new CoursesUI();
            coursesUI.run();
            break;
        }
        case "2":{
            StudentsUI studentsUI = new StudentsUI();
            studentsUI.run();
            break;
        }
        case "0":{
            System.exit(0);
            break;
        }
    }
        run();
    }

    private void startMessage() {
        System.out.println("Please choose what do you want to edit:\n" +
                "1 - Courses\n" +
                "2 - Students\n" +
                "0 - Exit");
    }

    public static String inputConstant() throws IOException {
        String number;
        do {
            System.out.println("Number: ");
            number = bufferedReader.readLine();
        } while (!number.matches(REGEX_NUMBER));
        return number;
    }
}
