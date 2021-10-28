package org.example.task2;

import java.util.List;
import java.util.concurrent.Callable;

public class CallablePrimeCounter implements Callable<Integer> {

    private final List<Integer> list;
    private final int startIndex;
    private final int endIndex;

    public CallablePrimeCounter(List<Integer> list, int startIndex, int endIndex) {
        this.list = list;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = startIndex; i < endIndex; i++) {
            if (isPrime(list.get(i))) {
                count++;
            }
        }

        System.out.println(Thread.currentThread().getName() + " counted " + count + " prime numbers");
        return count;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
