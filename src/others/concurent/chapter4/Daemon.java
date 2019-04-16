package others.concurent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程
 * @author liuxiao_sx
 * @date 2019/4/16
 */
public class Daemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
        //TimeUnit.SECONDS.sleep(100);
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try{
                System.out.println("DaemonThread  work.");//不一定执行
                SleepUtils.second(10);
            }finally {
                System.out.println("DaemonThread finally run.");//不一定执行
            }
        }
    }
}
