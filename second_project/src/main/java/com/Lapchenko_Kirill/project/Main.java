package com.Lapchenko_Kirill.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        System.out.println("Enter N (length of array): ");
        N = Integer.parseInt(reader.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter element: ");
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Tasks.task1(arr);
        Tasks.task2(arr);
        Tasks.task3(arr);
        Tasks.task4(arr);
        Tasks.task5(arr);
        Tasks.task6(arr);
    }
}
