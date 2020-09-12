package com.github.basic.java.concurent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @date 2019/10/9
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for(int i=0; i<10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
