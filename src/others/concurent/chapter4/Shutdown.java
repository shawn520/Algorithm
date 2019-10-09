package others.concurent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * 终止线程的两种方法
 * @author Shawn
 * @date 2019/10/9
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "countThread");
        countThread.start();
//        TimeUnit.SECONDS.sleep(1);
//        countThread.interrupt();
        Runner two = new Runner();
        Thread countThread2 = new Thread(two, "countThread2");
        countThread2.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
        countThread.interrupt();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(Thread.currentThread().getName() + ": Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
