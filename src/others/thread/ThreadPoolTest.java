package com.iqiyi.auto.util;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author liuxiao_sx
 * @date 2019/6/5
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
//        createNewCachedThreadPool ();
//        createFixedThreadPool();
//        createScheduledThreadPool();
        createSingleThreadPool();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*@Test
    public void test() {
//        createNewCachedThreadPool ();
//        createFixedThreadPool();
//        createScheduledThreadPool();
        createSingleThreadPool();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 创建一个可缓存线程池，应用中存在的线程数可以无限大
     */
    void createNewCachedThreadPool () {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0; i<4; i++) {
             int index = i;
            newCachedThreadPool.execute(new ThreadForPool(index));
        }
    }

    /**
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     */
    void createFixedThreadPool() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        for(int i=0; i<4; i++) {
            int index = i;
            newFixedThreadPool.execute(new ThreadForPool(index));
        }
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行
     */
    void createScheduledThreadPool() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
        for(int i=0; i<4; i++) {
            int index = i;
            // 延迟3s执行
            newScheduledThreadPool.schedule(new ThreadForPool(index), 3, TimeUnit.SECONDS);
        }

    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    void createSingleThreadPool() {
        ExecutorService newSingleThreadPool = Executors.newSingleThreadExecutor();
        for(int i=0; i<4; i++) {
            final int index = i;
            newSingleThreadPool.execute(new ThreadForPool(index));
        }

    }


    class ThreadForPool implements Runnable {

        private Integer index;

        ThreadForPool(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {

            System.out.println("开始处理线程任务...");
            try {
                Thread.sleep(index * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程标识是: " + this.toString());
        }
    }

}
