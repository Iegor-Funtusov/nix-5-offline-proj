package org.example;

import java.util.Queue;
import java.util.Random;

public class Horse implements Runnable {
    private static final int DISTANCE = 1000;

    private int covered = 0;
    private final Random luck = new Random();
    private final Queue<Horse> q;
    private final int id;

    public Horse(Queue<Horse> q, int id) {
        this.q = q;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            covered += 100 + luck.nextInt(101);
            if (covered >= DISTANCE) {
                q.add(this);
                break;
            }
            try {
                Thread.sleep(400 + luck.nextInt(101));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String toString() {
        return "Horse #" + id;
    }

    public int getId() {
        return id;
    }
}
