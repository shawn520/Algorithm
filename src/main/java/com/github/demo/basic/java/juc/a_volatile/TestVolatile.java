package com.github.demo.basic.java.juc.a_volatile;

/**
 * 背景：jvm为了提高cpu效率，给每个线程分配了单独的线程空间。
 * 多个线程操作共享变量时，会出现数据不一致问题。
 *
 * 方案：volatile解决多线程操作共享变量内存可见性问题
 * 如何解决：禁止指令重排
 *
 *
 * 注意：
 * 和synchronized相比：volatile相较于synchronized是一种轻量级的同步策略
 * 1. volatile不具有“互斥性”
 * 2. volatile不能保证变量的“原子性”
 *
 * @author Shawn
 * @date 2020/8/2
 */
public class TestVolatile {

  public static void main(String[] args) {
    ThreadDemo threadDemo = new ThreadDemo();
    new Thread(threadDemo).start();
    while (true) {
//      synchronized (threadDemo) {
//        if(threadDemo.isFlag()) {
//          System.out.println("-------------");
//          break;
//        }
//      }
        if(threadDemo.isFlag()) {
          System.out.println("-------------");
          break;
        }
    }
  }


}

class ThreadDemo implements Runnable {
  private volatile boolean flag = false;
  @Override
  public void run() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    setFlag(true);
    System.out.println("flag = " + isFlag());
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }
}
