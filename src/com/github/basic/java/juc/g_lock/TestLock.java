package com.github.basic.java.juc.g_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于解决线程安全问题的方法：
 *
 * synchronized： 隐式锁
 * 1. 同步代码块
 * 2. 同步方法
 *
 * jdk 1.5 以后： 显示锁
 * 3. 同步锁 lock
 *
 * 注意：是一个显式锁，需要通过unlock()方法释放锁。
 *
 * @author Shawn
 * @date 2020/8/9
 */
public class TestLock {
  public static void main(String[] args) {
    Ticket ticket = new Ticket();
    new Thread(ticket, "售票窗口1").start();
    new Thread(ticket, "售票窗口2").start();
    new Thread(ticket, "售票窗口3").start();
  }
}

class Ticket implements Runnable {
  private int tick = 100;
  private Lock lock = new ReentrantLock();

  @Override
  public void run() {
    while (true) {
      lock.lock();
      try{
        if(tick > 0) {
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread() + "售票，当前余票为" + --tick);
        }
      }finally {
        lock.unlock();
      }
    }
  }
}
