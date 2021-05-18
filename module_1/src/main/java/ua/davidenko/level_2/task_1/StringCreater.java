package ua.davidenko.level_2.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class StringCreater {
    public static String userString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your String for check");
        String checkString = br.readLine();
        return checkString;
    }

    public static String randomString(){
        String randomStr = " abcdefg()[]{}hiklmnopqaaa2qqqXXX";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randomStr.length(); i++) {
            sb.append(randomStr.charAt(random.nextInt(randomStr.length()-1)));

        }
       String randomStr1 = sb.toString();
        System.out.println("Your random Sting is : " + randomStr1);
        return randomStr1 ;
    }
}
