package org.example.task1;

public class HelloThread extends Thread {

    private Thread joined;

    @Override
    public void run() {
        try {
            if (joined != null) {
                joined.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello from thread " + getName());
    }

    public void setJoined(Thread joined) {
        this.joined = joined;
    }
}
