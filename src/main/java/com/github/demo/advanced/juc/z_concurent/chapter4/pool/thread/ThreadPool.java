package com.github.demo.advanced.juc.z_concurent.chapter4.pool.thread;

/**
 * @author Shawn
 * @date 2019/10/10
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorkers(int num);

    int getJobSize();
}
