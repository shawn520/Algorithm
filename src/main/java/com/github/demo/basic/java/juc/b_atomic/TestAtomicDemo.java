package com.github.demo.basic.java.juc.b_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. i++的原子性操作问题：实际分为“读改写”三个步骤
 *
 * 2. 原子变量：jdk1.5后java.java.concurrent.atomic中提供常用的原子变量
 * 1. volatile保重内存可见性
 * 2. CAS算法保证数据的原子性
 * CAS算法是硬件对于并发操作共享数据的支持
 * CAS包含三个操作数：
 * 内存之V
 * 预估值A
 * 更新值B
 * 当且仅当V==A时， V = B, 否则将不做任何操作
 * @author Shawn
 * @date 2020/8/2
 */
public class TestAtomicDemo {
  public static void main(String[] args) {
    ThreadAtomic threadAtomic = new ThreadAtomic();
    for(int i=0; i<10; i++) {
      new Thread(threadAtomic).start();
    }
  }
}

class ThreadAtomic implements Runnable {

//  private int serialNumber = 0;
  private AtomicInteger serialNumber = new AtomicInteger(0);
  @Override
  public void run() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(getSerialNumber());
  }

  public int getSerialNumber() {
    return serialNumber.getAndIncrement();
  }

  public void setSerialNumber(int serialNumber) {
    this.serialNumber.set(serialNumber);
  }
}
