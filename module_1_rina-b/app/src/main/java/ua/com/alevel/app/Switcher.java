package ua.com.alevel.app;

import ua.com.alevel.lvl1.*;
import ua.com.alevel.lvl2.StringCheck;
import ua.com.alevel.lvl3.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Switcher {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void uniqueNumberCount() throws IOException {
        System.out.println("How to run:\n" +
                "1 With user data\n" +
                "2 With default data\n");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice){
            case  1:
                System.out.println("Enter the length of array");
                int size = Integer.parseInt(reader.readLine());
                int[] list = new int[size];
                System.out.println("Enter elements through 'Enter' ");
                for (int i = 0; i < list.length; i++) {
                    String s = reader.readLine();
                    list[i] = Integer.parseInt(s);
                }
                System.out.println(UniqueNumber.uniqueCount(list));
                break;
            case 2:
                System.out.println("{1, 5, 4, 1, 3, 1}");
                int arr[] = {1, 5, 4, 1, 3, 1};
                System.out.println(UniqueNumber.uniqueCount(arr));
                break;
        }
    }

    public static void triangleS() throws IOException {
        System.out.println("How to run:\n" +
                "1 With user data\n" +
                "2 With default data\n");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice){
            case 1:
                System.out.println("Enter x1");
                double x1 = Double.parseDouble(reader.readLine());
                System.out.println("Enter y1");
                double y1 = Double.parseDouble(reader.readLine());
                System.out.println("Enter x2");
                double x2 = Double.parseDouble(reader.readLine());
                System.out.println("Enter y2");
                double y2 = Double.parseDouble(reader.readLine());
                System.out.println("Enter x3");
                double x3 = Double.parseDouble(reader.readLine());
                System.out.println("Enter y3");
                double y3 = Double.parseDouble(reader.readLine());
                System.out.println(TriangleS.sOfTriangle(x1,x2,x3, y1, y2,y3));
                break;
            case 2:
                System.out.println("x1 = 0, y1 = 0\n" +
                        "x2 = 0, y2 = 2\n" +
                        "x3 = 3, y3 = 0\n");
                System.out.println(TriangleS.sOfTriangle(0, 0, 3, 0, 2, 0));
                break;

        }
    }

    public static void chessHorseMove () throws IOException {
        HorseMove.chessBoard();
        HorseMove.horseMove();
    }

    public static void validityStringCheck() throws IOException {
        System.out.println("How to run:\n" +
                "1 With user data\n" +
                "2 With default data\n");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice){
            case 1:
                System.out.println("Enter the string");
                String src = reader.readLine();
                System.out.println(StringCheck.groupCheck(src));
                break;
            case 2:
                System.out.println("{(dsf)df[]}");
                System.out.println(StringCheck.groupCheck("{(dsf)df[]}"));
                break;
        }
    }
}