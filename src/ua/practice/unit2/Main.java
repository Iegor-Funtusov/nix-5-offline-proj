package ua.practice.unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input the length of an array:");
        ArrayClass arrayClass = new ArrayClass(Integer.parseInt(bufferedReader.readLine()));
        printOptions();
        String option;
        while ((option = bufferedReader.readLine()) != null) {
            switch (option) {
                case "1":
                    System.out.println(arrayClass);
                    break;
                case "2":
                    arrayClass.searchEven();
                    break;
                case "3":
                    arrayClass.searchPositive();
                    break;
                case "4":
                    arrayClass.searchCountOfElementsBiggerThanPrevious();
                    break;
                case "5":
                    arrayClass.countElementsWithBiggerValueThanNeighbours();
                    break;
                case "6":
                    arrayClass.reverseArray();
                    break;
                case "7":
                    arrayClass.swapNeighbours();
                    break;
                case "stop":
                    return;
                default:
                    System.out.println("Try again");
            }
        }
    }

    static void printOptions() {
        System.out.println("Input the number of your option:");
        System.out.println("1 - Show the array;");
        System.out.println("2 - Search even numbers in array;");
        System.out.println("3 - Search positive numbers in array;");
        System.out.println("4 - Search count of elements bigger than previous;");
        System.out.println("5 - Count elements with bigger value than neighbours;");
        System.out.println("6 - Reverse array;");
        System.out.println("7 - Swap neighbours;");
        System.out.println("stop - Stop the program;");
    }
}