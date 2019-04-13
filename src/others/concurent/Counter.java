package others.concurent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java原子操作实现示例
 * 实现基于CAS线程安全的计数器方法safeCount()和非线程安全计数器count
 * @author liuxiao_sx
 * @date 2019/4/13
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> threads = new ArrayList<>(600);
        long start = System.currentTimeMillis();

        //初始化100个线程，每个线程执行1w次计数
        for(int j=0; j<100; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0; i<10000; i++){
                        cas.safeCount();
                        cas.count();

                    }

                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        //等待所有线程执行完成
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //非线程安全的结果:<100w
        System.out.println(cas.i);
        //线程安全的结果: 100w
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);

    }

    /**
     * 使用CAS实现线程安全计数
     */
    private void safeCount() {
        //自旋CAS,直到成功为止
        for(;;) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 非线程安全计数
     */
    private void count() {
        i++;
    }

}
