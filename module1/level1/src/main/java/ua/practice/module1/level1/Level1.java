package ua.practice.module1.level1;

import ua.practice.module1.level1.triangle.Coordinate;
import ua.practice.module1.level1.triangle.Triangle;
import ua.practice.unit3.Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Level1 {

    public static int findNumberOfUniqueElementsWithSet(int[] array) {
        System.out.println(Arrays.toString(array));
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            set.add(value);
        }
        return set.size();
    }

    public static double findTriangleArea(Coordinate[] coordinates) {
        Triangle triangle = new Triangle(coordinates);
        return triangle.calculateArea();
    }

    public static void level1Options(BufferedReader bufferedReader) throws IOException {
        printOptions();
        String input = bufferedReader.readLine();
        switch (input) {
            case "1":
                System.out.println(findNumberOfUniqueElementsWithSet(new int[]{1, 4, 5, 1, 1, 3}));
                break;
            case "2":
                int[] array = createArray(bufferedReader);
                System.out.println(findNumberOfUniqueElementsWithSet(array));
                break;
            case "3":
                Coordinate[] arrayCoordinates = createCoordinate(bufferedReader);
                System.out.println(findTriangleArea(arrayCoordinates));
                break;
            case "4":
                Coordinate[] arrayCoordinates1 = new Coordinate[3];
                arrayCoordinates1[0] = new Coordinate(1, 2);
                arrayCoordinates1[1] = new Coordinate(4, 4);
                arrayCoordinates1[2] = new Coordinate(5, 2);
                System.out.println(findTriangleArea(arrayCoordinates1));
                break;
            case "5":
                Demo.main(null);
                break;
            case "6":
                return;
            default:
                System.out.println("Wrong Input. Try Again");
        }
    }

    private static int[] createArray(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input count of numbers:");
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Input number");
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        return array;
    }

    private static Coordinate[] createCoordinate(BufferedReader bufferedReader) throws IOException {
        Coordinate[] array = new Coordinate[3];
        int x;
        int y;
        for (int i = 0; i < 3; i++) {
            System.out.println("Input X");
            x = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Input Y");
            y = Integer.parseInt(bufferedReader.readLine());
            array[i] = new Coordinate(x, y);
        }
        return array;
    }

    private static void printOptions() {
        System.out.println("1 - Find Number Of Unique Elements in default array");
        System.out.println("2 - Find Number Of Unique Elements in your array");
        System.out.println("3 - Find Triangle area with your info");
        System.out.println("4 - Find Triangle area with default info");
        System.out.println("5 - Chess step");
        System.out.println("6 - Stop");
    }
}
