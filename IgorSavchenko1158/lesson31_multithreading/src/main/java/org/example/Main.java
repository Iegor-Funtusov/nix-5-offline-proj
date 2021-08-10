package org.example;

import org.example.task1.HelloTask;
import org.example.task2.PrimeTask;

public class Main {

    public static void main(String[] args) {
        new HelloTask().execute();
        new PrimeTask().execute();
    }
}
