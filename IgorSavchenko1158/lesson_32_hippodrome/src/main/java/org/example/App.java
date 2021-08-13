package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.*;

public class App {
    private static final int HORSES = 6;

    public static void main(String[] args) {
        System.out.println("There are " + HORSES + " horses, enter the number [0, " + (HORSES - 1) + "] to bet");
        int horseNumber = Integer.parseInt(new Scanner(System.in).nextLine());
        if (horseNumber < 0 || horseNumber >= HORSES) {
            throw new RuntimeException();
        }

        System.out.println("The race starts!");
        List<Horse> placements = race();

        System.out.println("Placements: ");
        for (int i = 0; i < placements.size(); i++) {
            System.out.println(i + 1 + ". " + placements.get(i));
        }
        System.out.println();

        int place = placements.indexOf(placements.stream().filter(h -> h.getId() == horseNumber).findFirst().get());
        System.out.println("Horse #" + horseNumber + " finished in " + (place + 1) + " place");
    }

    private static List<Horse> race() {
        Queue<Horse> finishOrder = new ConcurrentLinkedQueue<>();

        Thread[] threads = new Thread[HORSES];
        for (int i = 0; i < HORSES; i++) {
            threads[i] = new Thread(new Horse(finishOrder, i));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return new ArrayList<>(finishOrder);
    }
}
