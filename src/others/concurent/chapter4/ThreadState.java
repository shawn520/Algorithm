package others.concurent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * 使用jstack查看代码运行时的线程状态信息
 * @author liuxiao_sx
 * @date 2019/4/16
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        //两个block线程
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();

    }

    /**
     * 该线程不断睡眠
     */
    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);

            }
        }
    }

    //该线程在waiting.class实例上等待
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //该线程在Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                SleepUtils.second(100);
            }
        }
    }
}

class SleepUtils {
    public static final void second(long seconds) {
        try{
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * "BlockedThread-2" #16 prio=5 os_prio=0 tid=0x0000000018d58800 nid=0x2eac waiting for monitor entry [0x00000000189af000]
 *    java.lang.Thread.State: BLOCKED (on object monitor)
 *         at others.concurent.chapter4.ThreadState$Blocked.run(ThreadState.java:54)
 *         - waiting to lock <0x00000000d6490540> (a java.lang.Class for others.concurent.chapter4.ThreadState$Blocked)
 *         at java.lang.Thread.run(Thread.java:748)
 *
 * "BlockedThread-1" #15 prio=5 os_prio=0 tid=0x0000000018d55800 nid=0x3360 waiting on condition [0x000000001a3ee000]
 *    java.lang.Thread.State: TIMED_WAITING (sleeping)
 *         at java.lang.Thread.sleep(Native Method)
 *         at java.lang.Thread.sleep(Thread.java:340)
 *         at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 *         at others.concurent.chapter4.SleepUtils.second(ThreadState.java:63)
 *         at others.concurent.chapter4.ThreadState$Blocked.run(ThreadState.java:54)
 *         - locked <0x00000000d6490540> (a java.lang.Class for others.concurent.chapter4.ThreadState$Blocked)
 *         at java.lang.Thread.run(Thread.java:748)
 *
 * "WaitingThread" #14 prio=5 os_prio=0 tid=0x0000000018ceb000 nid=0x2280 in Object.wait() [0x000000001a29f000]
 *    java.lang.Thread.State: WAITING (on object monitor)
 *         at java.lang.Object.wait(Native Method)
 *         - waiting on <0x00000000d648d1c0> (a java.lang.Class for others.concurent.chapter4.ThreadState$Waiting)
 *         at java.lang.Object.wait(Object.java:502)
 *         at others.concurent.chapter4.ThreadState$Waiting.run(ThreadState.java:40)
 *         - locked <0x00000000d648d1c0> (a java.lang.Class for others.concurent.chapter4.ThreadState$Waiting)
 *         at java.lang.Thread.run(Thread.java:748)
 *
 * "TimeWaitingThread" #13 prio=5 os_prio=0 tid=0x0000000018ce6800 nid=0x2e48 waiting on condition [0x000000001a14f000]
 *    java.lang.Thread.State: TIMED_WAITING (sleeping)
 *         at java.lang.Thread.sleep(Native Method)
 *         at java.lang.Thread.sleep(Thread.java:340)
 *         at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 *         at others.concurent.chapter4.SleepUtils.second(ThreadState.java:63)
 *         at others.concurent.chapter4.ThreadState$TimeWaiting.run(ThreadState.java:27)
 *         at java.lang.Thread.run(Thread.java:748)
 */
