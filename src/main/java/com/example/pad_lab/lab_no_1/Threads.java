package com.example.pad_lab.lab_no_1;

import java.util.concurrent.CountDownLatch;

public class Threads {
    public static void main(String[] args) {
        CountDownLatch latch1 = new CountDownLatch(3);
        CountDownLatch latch2 = new CountDownLatch(1);

        // Create threads 1, 2, and 3
        for (int i = 1; i <= 3; i++) {
            int threadNumber = i;
            new Thread(() -> {
                System.out.println("Thread " + threadNumber);
                latch1.countDown();
            }).start();
        }

        // Create thread 4
        new Thread(() -> {
            try {
                latch1.await();
                System.out.println("Thread 4");
                latch2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Create threads 5, 6, and 7
        for (int i = 5; i <= 7; i++) {
            int threadNumber = i;
            new Thread(() -> {
                try {
                    latch2.await();
                    System.out.println("Thread " + threadNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}