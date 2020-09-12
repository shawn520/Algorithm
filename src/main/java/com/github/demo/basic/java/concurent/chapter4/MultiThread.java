package com.github.demo.basic.java.concurent.chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 使用JMX查看普通java程序包含哪些线程
 * @author Shawn
 * @date 2019/4/15
 */
public class MultiThread {
    public static void main(String[] args) {
        //获取java线程管理类
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo [] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }
}

/**
 * [6]Monitor Ctrl-Break
 * [5]Attach Listener
 * [4]Signal Dispatcher     处理发送给jvm信号的线程
 * [3]Finalizer             调用对象finalize的线程
 * [2]Reference Handler     清楚reference的线程
 * [1]main                  main线程程序入口
 *
 */
