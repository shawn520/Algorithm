package basic.java.juc.i_productorAndConsumerLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shawn
 * @date 2020/8/9
 */
public class TestProductorAndComsumerLock {
  public static void main(String[] args) {
    Clerk clerk = new Clerk();
    Productor productor = new Productor(clerk);
    Consumer consumer = new Consumer(clerk);
    new Thread(productor, "生产者 A").start();
    new Thread(consumer, "消费者 B").start();
    new Thread(productor, "生产者 A2").start();
    new Thread(consumer, "消费者 B2").start();
  }
}

class Clerk {
  private int product = 0;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  //进货
  public void get() {
    lock.lock();
    try{
      while(product>=1) {
        System.out.println("库存已满!进货失败");
        try {
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName() + ": " + ++product);
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }

  //卖货
  public void sale() {
    lock.lock();
    try {
      while(product<=0) {
        System.out.println("产品库存不足！");
        try {
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName() + ": " + --product);
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }
}

// 生产者
class Productor implements Runnable {
  private Clerk clerk;

  Productor(Clerk clerk) {
    this.clerk = clerk;
  }

  @Override
  public void run() {
    for(int i=0; i<20; i++) {
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      clerk.get();
    }
  }
}

// 消费者
class Consumer implements Runnable {
  private Clerk clerk;

  Consumer(Clerk clerk) {
    this.clerk = clerk;
  }

  @Override
  public void run() {
    for(int i=0; i<20 ;i++) {
      clerk.sale();
    }
  }
}
