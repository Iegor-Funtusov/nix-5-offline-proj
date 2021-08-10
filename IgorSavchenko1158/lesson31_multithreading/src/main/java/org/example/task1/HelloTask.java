package org.example.task1;

public class HelloTask {

    private static final int COUNT = 50;

    public void execute() {
        HelloThread[] threads = new HelloThread[COUNT];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new HelloThread();
        }
        for (int i = COUNT - 2; i >= 0; i--) {
            threads[i].setJoined(threads[i + 1]);
        }

        for (HelloThread thread : threads) {
            thread.start();
        }
    }
}
