package com.github.demo.basic.java.juc.e_countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 在完成某些运算时，只有当其他所有线程的运算全部完成时，当前运算才继续执行。
 * @author Shawn
 * @date 2020/8/8
 */
public class TestCountDownLatch {
  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(5);
    LatchDemo latchDemo = new LatchDemo(latch);

    long start = System.currentTimeMillis();
    for(int i=0; i<5; i++) {
      new Thread(latchDemo).start();
    }

    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println("耗费时间为: " + (end-start));
  }
}

class LatchDemo implements Runnable {

  private CountDownLatch latch;

  LatchDemo(CountDownLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    try{
      for(int i=0; i<50000; i++) {
        if(i%2==0) {
          System.out.println(i);
        }
      }
    }finally {
      latch.countDown();
    }
  }
}
