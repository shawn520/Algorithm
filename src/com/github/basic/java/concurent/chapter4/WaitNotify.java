package com.github.basic.java.concurent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * 线程间通信
 * 等待/通知机制
 * thread wait/notify
 * @author liuxiao_sx
 * @date 2019/4/17
 */
public class WaitNotify {
    static volatile boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                //flag = ture, thread wait,  release lock.
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true.wait");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //after notify, execute
                System.out.println(Thread.currentThread() + "flag is false. running");
            }

        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            //lock
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock. notify");
                lock.notify();
                flag = false;
            }
            //SleepUtils.second(5);
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock again. ");
                SleepUtils.second(5);
            }
        }
    }
}

/*
执行结果
Thread[WaitThread,5,main]flag is true.wait
Thread[NotifyThread,5,main]hold lock. notify
Thread[NotifyThread,5,main]hold lock again.
Thread[WaitThread,5,main]flag is false. running
 */
