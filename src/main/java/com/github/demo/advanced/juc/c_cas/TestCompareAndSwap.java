package com.github.demo.advanced.juc.c_cas;

/**
 * 模拟cas算法
 * @author Shawn
 * @date 2020/8/2
 */
public class TestCompareAndSwap {
  public static void main(String[] args) {
    final CompareAndSwap cas = new CompareAndSwap();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i=0; i<10;i++) {
          int value = cas.getValue();
          boolean res = cas.compareAndSet(value, (int)Math.random() * 101);
          System.out.println(res);
        }
      }
    }).start();
  }
}

class CompareAndSwap {
  private int value;

  public synchronized int compareAndSwap(int expectedValue, int newValue) {
    int oldValue = value;
    if(oldValue == expectedValue) {
      this.value = newValue;
    }
    return oldValue;
  }

  public synchronized boolean compareAndSet(int expectedValue, int newValue) {
    return expectedValue ==compareAndSwap(expectedValue, newValue);
  }

  public synchronized int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
