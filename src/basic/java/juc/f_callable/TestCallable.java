package basic.java.juc.f_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式3：
 * 实现callable接口，
 * 相较于实现Runnable接口，方法可以有返回值，并且可以抛出异常。
 * @author Shawn
 * @date 2020/8/9
 */
public class TestCallable {
  public static void main(String[] args) {
    ThreadDemo threadDemo = new ThreadDemo();

    // 1.执行Callable，需要FutureTask实现类的支持，用于接收运算结果
    FutureTask<Integer> result = new FutureTask<>(threadDemo);
    new Thread(result).start();

    // 2.接收线程运算后的结果, FutureTask可用于闭锁（countDownLatch ）
    try {
      Integer sum = result.get();
      System.out.println(sum);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }

}

class ThreadDemo implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    int sum =0;
    for(int i=0; i<101; i++) {
      sum += i;
    }
    return sum;
  }
}
