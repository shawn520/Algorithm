package basic.java.juc.i_productorAndConsumerLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程按序交替执行
 * @author Shawn
 * @date 2020/8/9
 */
public class TestABCAlternate {
  public static void main(String[] args) {
    AlternateDemo alternateDemo = new AlternateDemo();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i=0; i<20; i++) {
          alternateDemo.loopA(i);
        }
      }
    }, "A").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i=0; i<20; i++) {
          alternateDemo.loopB(i);
        }
      }
    }, "B").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i=0; i<20; i++) {
          alternateDemo.loopC(i);

          System.out.println("-------------------");
        }
      }
    }, "C").start();
  }

}

class AlternateDemo {
  private int number = 1;
  private Lock lock = new ReentrantLock();
  private Condition condition1 = lock.newCondition();
  private Condition condition2 = lock.newCondition();
  private Condition condition3 = lock.newCondition();

  public void loopA(int totalLoop) {
    lock.lock();
    try{
      if(number != 1) {
        condition1.await();
      }
      for(int i=0; i<1; i++) {
        System.out.println(Thread.currentThread().getName()+'\t' + i + '\t' + totalLoop);
      }
      number = 2;
      condition2.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void loopB(int totalLoop) {
    lock.lock();
    try{
      if(number != 2) {
        condition2.await();
      }
      for(int i=0; i<1; i++) {
        System.out.println(Thread.currentThread().getName()+'\t' + i + '\t' + totalLoop);
      }
      number = 3;
      condition3.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void loopC(int totalLoop) {
    lock.lock();
    try{
      if(number != 3) {
        condition3.await();
      }
      for(int i=0; i<1; i++) {
        System.out.println(Thread.currentThread().getName() +'\t' + i + '\t' + totalLoop);
      }
      number = 1;
      condition1.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
