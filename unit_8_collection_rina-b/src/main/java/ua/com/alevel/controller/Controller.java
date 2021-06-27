package ua.com.alevel.controller;

import ua.com.alevel.mathset.MathSet;

import java.util.Arrays;

public class Controller {
    static MathSet<Number> mathSet = new MathSet<>();
    static Number[] numbers1 = {22, 33, 44, 55, 66, 77};
    static Number[] numbers2 = {11, 12, 13, 15, 14};
    static MathSet<Number> numberSet1 = new MathSet<>(numbers1);
    static MathSet<Number> numberSet2 = new MathSet<>(numbers2);

    public static void controller() {
        System.out.println("First Array:\n"+ Arrays.toString(numberSet1.toArray()));
        System.out.println("Second Array:\n"+ Arrays.toString(numberSet2.toArray()));
        System.out.println(" ");

        System.out.println("Add number to first Array :");
        numberSet1.add(6);
        System.out.println(Arrays.toString(numberSet1.toArray()));
        System.out.println(" ");

        System.out.println("Join:");
        mathSet.join(numberSet1, numberSet2);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(" ");

        System.out.println("Sort Desc:");
        mathSet.sortDesc();
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(" ");

        System.out.println("Sort Asc:");
        mathSet.sortAsc();
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(" ");


        System.out.println("Sort Desc from index(1) to index(3)");
        mathSet.sortDesc(1, 4);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(" ");
        System.out.println("Sort Asc from index(1) to index(2)");
        mathSet.sortAsc(1, 3);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(" ");

        System.out.println("Sort Desc from value(14):");
        mathSet.sortDesc(14);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(" ");
        System.out.println("Sort Asc from value(22):");
        mathSet.sortDesc(22);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(" ");

        System.out.print("Get number by index(1): ");
        System.out.println(mathSet.get(1));
        System.out.println(" ");

        System.out.println("Max value: " + mathSet.getMax());
        System.out.println(" ");

        System.out.println("Min value: " + mathSet.getMin());
        System.out.println(" ");

        System.out.println("Average: " + mathSet.getAverage());
        System.out.println(" ");

        System.out.println("Median: " + mathSet.getMedian());
        System.out.println(" ");

        int[] range = new int[]{1, 5};
        System.out.println("Array from index (1) to index (4):\n" + Arrays.toString(mathSet.toArray(range[0], range[1])));
        System.out.println(" ");
        System.out.println("Array:\n" + Arrays.toString(mathSet.toArray()));
        System.out.println(" ");

        int[] range1 = new int[]{2, 6};
        System.out.println("Squash array from index (2) to index (5):\n" + Arrays.toString(mathSet.squash(range1[0], range1[1]).toArray()));
        System.out.println(" ");

        Number[] numbers = {33, 66, 14};
        mathSet.clear(numbers);
        System.out.println("Clear array values(3, 6, 14):\n" + Arrays.toString(mathSet.toArray()));
        System.out.println(" ");
        mathSet.clear();
        System.out.println("Clear array:\n" + Arrays.toString(mathSet.toArray()));
        System.out.println(" ");
    }
}
