package com.Lapchenko_Kirill.project.first_level.first_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueNumbers {

    private int[] numbers;

    public int countUniqueNumbers(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (Integer a :
                arr) {
            set.add(a);
        }
        return set.size();
    }

    public void printArr() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public int[] generateRandom() {
        numbers = new int[new Random().nextInt(10)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(10);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        return numbers;
    }

    public int[] askUserFillArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = 0;
        String regex = "\\d+";
        System.out.println("Please enter your desired length of array");
        while (true) {
            String userInput = reader.readLine();
            if (userInput.matches(regex)) {
                arrSize = Integer.parseInt(userInput);
                numbers = new int[arrSize];
                break;
            } else {
                System.out.println("Wrong input, try again!");
            }
        }
        System.out.println("Please enter array numbers: ");
        for (int i = 0; i < arrSize; i++) {
            System.out.println("Please enter number: ");
            while (true) {
                String userInput = reader.readLine();
                if (userInput.matches(regex)) {
                    numbers[i] = Integer.parseInt(userInput);
                    break;
                } else {
                    System.out.println("Wrong input, try again!");
                }
            }
        }
        return numbers;
    }
}
