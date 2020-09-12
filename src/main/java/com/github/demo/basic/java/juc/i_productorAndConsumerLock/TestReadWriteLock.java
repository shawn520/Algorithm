package com.github.demo.basic.java.juc.i_productorAndConsumerLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Shawn
 * @date 2020/8/10
 */
public class TestReadWriteLock {
  public static void main(String[] args) {
    ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

    new Thread(new Runnable() {
      @Override
      public void run() {
        readWriteLockDemo.set(10);
      }
    }, "write thread").start();

    for(int i=0;i<100;i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          readWriteLockDemo.get();
        }
      }, "read thread" + i).start();
    }

  }

}

class ReadWriteLockDemo {
  private int number = 0;
  private ReadWriteLock lock = new ReentrantReadWriteLock();

  public void get() {
    lock.readLock().lock();
    try{
      System.out.println(Thread.currentThread().getName() + ": " + number);
    } finally {
      lock.readLock().unlock();
    }
  }

  public void set(int number) {
    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    lock.writeLock().lock();
    try{
      this.number = number;
      System.out.println(Thread.currentThread().getName());
    } finally {
      lock.writeLock().unlock();
    }

  }
}
