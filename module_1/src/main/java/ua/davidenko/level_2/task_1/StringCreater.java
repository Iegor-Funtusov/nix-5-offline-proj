package ua.davidenko.level_2.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCreater {
    public static String userString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your String for check");
        String checkString = br.readLine();


        return checkString;
    }
}
