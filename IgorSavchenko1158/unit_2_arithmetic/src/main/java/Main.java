import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter size of array followed by numbers:");

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(array));

        printEvenElements(array);
        printNumOfPositives(array);
        printNumOfBiggerThanPrevious(array);
        printNumOfBiggerThanNeighbors(array);
        printReverse(array);
        printSwitchedNeighbors(array);
    }

    /**
     * 1. Дан массив, состоящий из целых чисел. Напишите программу, которая выводит те
     * элементы массива, которые являются чётными числами. Необходимо вывести все четные
     * элементы массива (то есть те элементы, которые являются четными числами).
     */
    public static void printEvenElements(int[] array) {
        System.out.println("Main.printEvenElements");
        for (int i : array) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * 2. Дан массив, состоящий из целых чисел. Напишите программу, которая подсчитывает количество
     * положительных чисел среди элементов массива. Необходимо единственное число - количество
     * положительных элементов в массиве.
     */
    public static void printNumOfPositives(int[] array) {
        System.out.println("Main.printNumOfPositives");
        int count = 0;
        for (int i : array) {
            if (i > 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * 3. Дан массив, состоящий из целых чисел. Напишите программу, которая подсчитает количество элементов массива,
     * больших предыдущего (элемента с предыдущим номером). Необходимо вывести единственное число - количество
     * элементов массива, больших предыдущего.
     */
    public static void printNumOfBiggerThanPrevious(int[] array) {
        System.out.println("Main.printNumOfBiggerNumbers");
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * 4. Дан массив, состоящий из целых чисел. Напишите программу, которая в данном массиве определит количество
     * элементов, у которых два соседних и, при этом, оба соседних элемента меньше данного. Необходимо вывести
     * количество элементов массива, у которых два соседа и которые при этом строго больше обоих своих соседей.
     */
    public static void printNumOfBiggerThanNeighbors(int[] array) {
        System.out.println("Main.printNumOfBiggerThanNeighbors");

        int count = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * 5. Напишите программу, которая переставляет элементы массива в обратном порядке без использования дополнительного
     * массива. Программа должна считать массив, поменять порядок его элементов, затем вывести результат
     * (просто вывести элементы массива в обратном порядке – недостаточно!).
     * Необходимо вывести массив, полученный после перестановки элементов.
     */
    public static void printReverse(int[] array) {
        System.out.println("Main.printReverse");

        int[] inner = Arrays.copyOf(array, array.length);

        int buffer = 0;
        for (int i = 0; i < inner.length / 2; i++) {
            buffer = inner[i];
            inner[i] = inner[inner.length - 1 - i];
            inner[inner.length - 1 - i] = buffer;
        }

        for (int i : inner) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 6. Напишите программу, которая переставляет соседние элементы массива
     * (1-й элемент поменять с 2-м, 3-й с 4-м и т.д. Если элементов нечетное число,
     * то последний элемент остается на своем месте). Необходимо вывести массив,
     * полученный после перестановки элементов.
     */
    public static void printSwitchedNeighbors(int[] array) {
        System.out.println("Main.printSwitchedNeighbors");

        int[] inner = Arrays.copyOf(array, array.length);

        int buffer = 0;
        for (int i = 1; i < inner.length; i += 2) {
            buffer = inner[i];
            inner[i] = inner[i - 1];
            inner[i - 1] = buffer;
        }

        for(int i : inner) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
