package com.github.demo.advanced.juc.z_concurent.chapter4.pool.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Shawn
 * @date 2019/10/10
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private static final int MAX_WORKER_NUMBERS = 10;

    private static final int DEFAULT_WORKER_NUMBERS = 5;

    private static final int MIN_WORKER_NUMBERS = 1;

    private final LinkedList<Job> jobs = new LinkedList<>();

    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workerNum = DEFAULT_WORKER_NUMBERS;

    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    @Override
    public void execute(Job job) {
        if(null != job) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }

    }

    @Override
    public void shutdown() {
        for(Worker worker: workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if(num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs) {
            if(num > this.workerNum) {
                throw new IllegalArgumentException("beyond workNum.");
            }
            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if(workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num) {
        for(int i=0; i<num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null) {
                    job.run();
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }
}

