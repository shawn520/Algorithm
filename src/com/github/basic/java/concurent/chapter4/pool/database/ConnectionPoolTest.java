package com.github.basic.java.concurent.chapter4.pool.database;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟客户端获取，使用和释放连接
 * @author liuxiao_sx
 * @date 2019/4/18
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    /**
     * 保证所有ConnectionRunner同时开始
     */
    static CountDownLatch start = new CountDownLatch(1);
    /**
     * main线程将会等待所有ConnectionRunner结束后才会继续执行
     */
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i=0; i< threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot), "ConnetionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);

    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if(null != connection) {
                        try{
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}

/**
 * total invoke: 1000
 * got connection: 798
 * not got connection: 202
 * Disconnected from the target VM, address: '127.0.0.1:7281', transport: 'socket'
 */
