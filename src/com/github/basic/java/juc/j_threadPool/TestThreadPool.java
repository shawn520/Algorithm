package com.github.basic.java.juc.j_threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 一、线程池：提供了一个线程队列，队列中保存所有等待状态的线程，
 * 避免频繁创建与销毁线程造成的额外开销
 *
 * 二、线程池的体系结构：
 * java.java.concurrent.Executor:负责线程的使用和调度的根接口
 *    |--ExecutorService 子接口：线程池的主要接口
 *      |--ThreadPoolExecutor 线程池的实现类：
 *      |--ScheduleExecutorService 子接口：负责线程调度
 *        |--ScheduledThreadPoolExecutor 实现类：继承了ThreadPoolExecutor，实现了ScheduleExecutorService
 *
 * 三、工具类 Executors
 * ExecutorService newFixedThreadPool(): 创建固定大小的线程池
 * ExecutorService newCachedThreadPool():缓存线程池，线程的数量不固定，可以根据需求自动更改数量
 * ExecutorService newSingleThreadPoll():创建单线程的线程池
 *
 * ScheduleExecutorService newScheduledThreadPool(): 创建固定大小的线程池，可以延迟或者定时执行任务
 * @author Shawn
 * @date 2020/8/10
 */
public class TestThreadPool {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 1. 创建线程
    ExecutorService pool = Executors.newFixedThreadPool(5);
    ThreadPoolDemo tpd = new ThreadPoolDemo();
    List<Future<Integer>> list = new ArrayList<>();
    for(int i=0; i<10; i++) {
      Future<Integer> future = pool.submit(new Callable<Integer>() {

        @Override
        public Integer call() throws Exception {
          int sum = 0;
          for(int i=0; i<= 100; i++) {
            sum += i;
          }
          return sum;
        }
      });
      list.add(future);
    }

    pool.shutdown();
    for(Future<Integer> future: list) {
      System.out.println(future.get());
    }

    // 2. 为线程池中的线程分配任务
//    for(int i=0; i<10; i++) {
//      pool.submit(tpd);
//    }

    // 3. 关闭线程池
//    pool.shutdown();
  }
}

class ThreadPoolDemo implements Runnable {

  @Override
  public void run() {
    for(int i=0; i<100; i++) {
      System.out.println(Thread.currentThread().getName() +": " + i);
    }
  }
}
