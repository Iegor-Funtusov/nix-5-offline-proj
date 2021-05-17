package ua.com.alevel.app;

import ua.com.alevel.lib.reversString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainClass {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
       while (true){
           System.out.println("Enter the way of run:\n" +
                   "1 With default data\n" +
                   "2 With user data\n" +
                   "0 Exit");
           int choice = Integer.parseInt(reader.readLine());
           switch (choice){
               case  1:
                   DefaultData();
                   break;
               case 2:
                   Choose();
                   break;
               case 0:
                   System.exit(0);
           }

       }


    }

    public static void DefaultData(){
        String src = "hello world";
        String dest = "worl";
        System.out.println(reversString.simpleReverse(src));
        System.out.println(reversString.reverseBySubstring(src, dest));
        System.out.println(reversString.reverseByIndex(src,3, 7));
        System.out.println(reversString.reverseByUser(src, "lo", "or"));
    }

    public static void Choose() throws IOException{
        System.out.println("Select an option:\n" +
                "1 Simple revers\n" +
                "2 Reverse by substring\n" +
                "3 Reverse by index\n" +
                "4 Reverse by CharSequence\n" +
                "0 Exit");
        int choice = Integer.parseInt(reader.readLine());

        switch (choice){
            case 1:
                System.out.println("Enter the string");
                String src = reader.readLine();
                System.out.println(reversString.simpleReverse(src));
                break;
            case 2:
                System.out.println("Enter the string");
                src = reader.readLine();
                System.out.println("Enter the substring");
                String dest = reader.readLine();
                System.out.println(reversString.reverseBySubstring(src, dest));
                break;
            case 3:
                System.out.println("Enter the string");
                src = reader.readLine();
                System.out.println("Enter the first index");
                int firstIndex = Integer.parseInt(reader.readLine());
                System.out.println("Enter the last index");
                int lastIndex = Integer.parseInt(reader.readLine());
                System.out.println(reversString.reverseByIndex(src, firstIndex, lastIndex));
                break;
            case 4:
                System.out.println("Enter the string");
                src = reader.readLine();
                System.out.println("Enter the start CharSequence");
                String start = reader.readLine();
                System.out.println("Enter the end CharSequence");
                String end = reader.readLine();
                System.out.println(reversString.reverseByUser(src, start, end));
                break;
            case 0:
                System.exit(0);
        }
    }
}