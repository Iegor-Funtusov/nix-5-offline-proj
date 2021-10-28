package org.example.task2;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PrimeTask {
    public void execute() {
        List<Integer> list = generateList();

        Callable<Integer> callable = new CallablePrimeCounter(list, 0, list.size() / 2);
        FutureTask<Integer> firstTask = new FutureTask<>(callable);

        callable = new CallablePrimeCounter(list, list.size() / 2, list.size());
        FutureTask<Integer> secondTask = new FutureTask<>(callable);

        Thread firstThread = new Thread(firstTask);
        firstThread.setName("First half");
        firstThread.start();

        Thread secondThread = new Thread(secondTask);
        secondThread.setName("Second half");
        secondThread.start();

        try {
            System.out.println(firstTask.get() + secondTask.get() + " is the total number of primes");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Integer> generateList() {
        return List.of(27, 30, 37, 38, 46, 57, 61, 63, 80, 97);
    }
}
