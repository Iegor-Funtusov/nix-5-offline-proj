package org.example.application;

import org.example.numeric_set.MathSet;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class UI {
    private static final String WRONG = "Incorrect input";

    private static MathSet<Integer> mset = new MathSet<>();

    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=======");
            if (mset.size() == 0) {
                System.out.println("MathSet is empty");
            } else {
                System.out.println("MathSet contents: " + Arrays.toString(mset.toArray()));
            }
            System.out.println("Available commands:");
            System.out.println("0 to exit");
            System.out.println("fill #To fill with random numbers");
            System.out.println("add x [y z] #To add one or more numbers to set");
            System.out.println("sort [desc] #To sort descending or ascending (default)");
            System.out.println("get i #To retrieve number with index i");
            System.out.println("getMax");
            System.out.println("getMin");
            System.out.println("getAverage");
            System.out.println("getMedian");
            System.out.println("squash firstIndex lastIndex");
            System.out.println("clear");

            String[] input = scanner.nextLine().strip().split("\\s");
            for (int i = 0; i < input.length; i++) {
                input[i] = input[i].toLowerCase(Locale.ROOT);
            }
            switch (input[0]) {
                case "0":
                    return;
                case "fill": {
                    fill();
                    break;
                }
                case "add": {
                    add(input);
                    break;
                }
                case "sort": {
                    sort(input, scanner);
                    break;
                }
                case "get": {
                    get(input);
                    break;
                }
                case "getmax": {
                    getMax();
                    break;
                }
                case "getmin": {
                    getMin();
                    break;
                }
                case "getaverage": {
                    getAverage();
                    break;
                }
                case "getmedian": {
                    getMedian();
                    break;
                }
                case "squash": {
                    squash(input);
                    break;
                }
                case "clear": {
                    clear();
                    break;
                }
                default:{
                    System.out.println(WRONG);
                }
            }
        }
    }

    public static void fill() {
        Random r = new Random();
        int capacity = 5 + r.nextInt(11);
        mset = new MathSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            mset.add(r.nextInt(101));
        }
    }

    public static void add(String[] input) {
        int next;
        for (int i = 1; i < input.length; i++) {
            try {
                next = Integer.parseInt(input[i]);
                mset.add(next);
            } catch (NumberFormatException e) {
                System.out.println(WRONG);
            }
        }
    }

    public static void sort(String[] input, Scanner scanner) {
        boolean asc = true;
        if (input.length > 1) {
            if (input[1].equals("desc")) {
                asc = false;
            } else {
                System.out.println(WRONG);
            }
        }
        System.out.println("Sorting " + (asc ? "ascending" : "descending"));
        System.out.println("Enter two numbers separated by space to sort limited by indexes;\n" +
                "enter one number to sort from first number to entered number; \n" +
                "enter empty string to sort entire set");
        String[] sortInput = scanner.nextLine().strip().split("\\s");
        if (sortInput.length == 2) {
            int firstIndex;
            int lastIndex;
            try {
                firstIndex = Integer.parseInt(sortInput[0]);
                lastIndex = Integer.parseInt(sortInput[1]);
            } catch (NumberFormatException e) {
                System.out.println(WRONG);
                return;
            }
            if (asc) {
                mset.sortAsc(firstIndex, lastIndex);
            } else {
                mset.sortDesc(firstIndex, lastIndex);
            }
            return;
        }
        if (sortInput[0].isEmpty()) {
            if (asc) {
                mset.sortAsc();
            } else {
                mset.sortDesc();
            }
            return;
        }
        if (sortInput.length == 1) {
            int number;
            try {
                number = Integer.parseInt(sortInput[0]);
            } catch (NumberFormatException e) {
                System.out.println(WRONG);
                return;
            }
            if (asc) {
                mset.sortAsc(number);
            } else {
                mset.sortDesc(number);
            }
        }
    }

    public static void get(String[] input) {
        if (input.length != 2) {
            System.out.println(WRONG);
            return;
        }
        int index;
        try {
            index = Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            System.out.println(WRONG);
            return;
        }
        Integer result = mset.get(index);
        if (result != null) {
            System.out.println("Number with index " + index + " is " + result);
        } else {
            System.out.println("No element with such index");
        }
    }

    public static void getMax() {
        if (mset.size() == 0) {
            System.out.println("MathSet is empty");
            return;
        }
        Integer max = mset.getMax();
        System.out.println("Max = " + max);
    }

    private static void getMin() {
        if (mset.size() == 0) {
            System.out.println("MathSet is empty");
            return;
        }
        Integer min = mset.getMin();
        System.out.println("Min = " + min);
    }

    private static void getAverage() {
        if (mset.size() == 0) {
            System.out.println("MathSet is empty");
            return;
        }
        Double avg = mset.getAverage();
        System.out.println("Average = " + avg);
    }

    private static void getMedian() {
        if (mset.size() == 0) {
            System.out.println("MathSet is empty");
            return;
        }
        Double median = mset.getMedian();
        System.out.println("Median = " + median);
    }

    private static void squash(String[] input) {
        if (input.length != 3) {
            System.out.println(WRONG);
            return;
        }
        int firstIndex;
        int lastIndex;
        try {
            firstIndex = Integer.parseInt(input[1]);
            lastIndex = Integer.parseInt(input[2]);
        } catch (NumberFormatException e) {
            System.out.println(WRONG);
            return;
        }
        MathSet<Integer> temp = mset.squash(firstIndex, lastIndex);
        if (temp == null) {
            System.out.println(WRONG);
            return;
        }
        mset = temp;
    }

    private static void clear() {
        mset.clear();
    }
}
