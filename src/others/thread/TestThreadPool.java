package others.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String [] args ) throws Exception{
        ExecutorService executorService = new ThreadPoolExecutor(1,1,
                60L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        executorService.execute(new MyRunnable());
    }
}
