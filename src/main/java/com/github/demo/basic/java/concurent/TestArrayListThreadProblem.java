package com.github.demo.basic.java.concurent;

import java.util.ArrayList;
import java.util.List;

/**
 * Array List的线程安全问题
 * public boolean add(E e) {
 *    ensureCapacityInternal(size + 1);  // Increments modCount!!
 *    elementData[size++] = e;
 *    return true;
 * }
 *
 * add方法不是原子操作：
 * 1. 假设list的容量为8,当前size为7，第一个线程进来，无需扩容但是还未执行size++操作
 * 此时第二个线程进来，也无需扩容，这时第一个线程执行elementData[7]=1,第二个线程执行elementData[8]=2
 * 出现数组越界异常ArrayIndexOutOfBoundsException:8
 *
 *2. elementData[size++] 不是原子操作，elementData[size] 和size++两步。
 * 假设当前位置为8，第一个线程执行elementData[8] = 1, 还未执行size++
 * 此时第二个线程进来执行elementData[8]=2覆盖了第一个线程写入的数据
 * 然后两个线程分别执行size++,此时size=10，但是elementData[9]=null,报空指针异常。
 *
 *
 * @author Shawn
 * @date 2020/9/22
 */
public class TestArrayListThreadProblem {
    public static void main(String[] args) throws InterruptedException {
        final List<Integer> list = new ArrayList<Integer>();

        // 线程A将0-1000添加到list
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000 ; i++) {
                    list.add(i);
//                    synchronized (list) {
//                        list.add(i);
//                    }

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1000; i < 2000 ; i++) {
                    list.add(i);
//                    synchronized (list) {
//                        list.add(i);
//                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }
}
//    Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: 33
//        at java.util.ArrayList.add(ArrayList.java:463)
//        at com.github.demo.basic.java.concurent.TestArrayListThreadProblem$1.run(TestArrayListThreadProblem.java:18)
//        at java.lang.Thread.run(Thread.java:748)
