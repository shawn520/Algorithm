package com.github.basic.java.concurent.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程优先级
 * 感觉线程优先级在windows系统还是有效的
 * @author Shawn
 * @date 2019/4/15
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for(int i=0; i<10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        //所有线程开始计数
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        //所有线程停止计数
        notEnd = false;
        for(Job job : jobs) {
            System.out.println("Job Priority: " + job.priority + ", count:" + job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int priority;
        private long jobCount;
        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}

/**
 * Job Priority: 1, count:5519668
 * Job Priority: 1, count:5305758
 * Job Priority: 1, count:5444105
 * Job Priority: 1, count:5336591
 * Job Priority: 1, count:5252539
 * Job Priority: 10, count:5831100
 * Job Priority: 10, count:5773961
 * Job Priority: 10, count:5839846
 * Job Priority: 10, count:5702005
 * Job Priority: 10, count:5717252
 */

