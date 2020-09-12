package com.github.demo.basic.java.juc.j_threadPool;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author Shawn
 * @date 2020/8/11
 */
public class TestForkJoinPool {
  public static void main(String[] args) {
    Instant start = Instant.now();

    ForkJoinPool pool = new ForkJoinPool();
    ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 100000000L);
    long sum = pool.invoke(task);
    System.out.println(sum);
    Instant end = Instant.now();
    System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
  }

  @Test
  public void test2() {
    Instant start = Instant.now();
    long sum = LongStream.rangeClosed(0L, 100000000L)
            .parallel()
            .reduce(0L, Long::sum);
    Instant end = Instant.now();
    System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());

  }

  @Test
  public void test() {
    // 请输出平均值、最大值、最小值
    int a[] = {4,5,1,3,4,20,2};
    int avg = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for(int i=0; i<a.length;i++) {
      avg += a[i];
      if(a[i] > max) max = a[i];
      if(a[i] < min) min = a[i];
    }
    avg /= a.length;
    System.out.println("平均值：" +avg);
    System.out.println("最大值：" +max);
    System.out.println("最小值：" +min);
  }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {

  private long start;
  private long end;

  private static final Long THRESHHOLD = 10000L;

  ForkJoinSumCalculate(long start, long end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    long length = end -start;
    if(length<THRESHHOLD) {
      long sum = 0L;
      for(long i=start; i< end; i++) {
        sum += i;
      }
      return sum;
    } else {
      long mid = (start + end)/2;
      ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, mid);
      left.fork();  //进行拆分，同时压入线程队列
      ForkJoinSumCalculate right = new ForkJoinSumCalculate(mid+1, start);
      right.fork();
      return left.join() + right.join();
    }
  }
}
