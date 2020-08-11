package basic.java.juc.j_threadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 一、线程池：提供了一个线程队列，队列中保存所有等待状态的线程，
 * 避免频繁创建与销毁线程造成的额外开销
 *
 * 二、线程池的体系结构：
 * java.util.concurrent.Executor:负责线程的使用和调度的根接口
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
public class TestScheduledThreadPool {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
    for(int i=0; i<5; i++) {
      Future<Integer> result = pool.schedule(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          int num = new Random().nextInt(100);
          System.out.println(Thread.currentThread().getName() +": " + num);
          return num;
        }
      },3, TimeUnit.SECONDS);
      System.out.println(result.get());
    }
    pool.shutdown();
  }
}
