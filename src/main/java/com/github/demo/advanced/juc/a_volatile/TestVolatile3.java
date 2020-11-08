package com.github.demo.advanced.juc.a_volatile;

/**
 * @author Shawn
 * @date 2020/11/8
 */
public class TestVolatile3 {

    public static void main(String[] args) {
        TV tv = new TV();
        new Thread(tv, "小明").start();
        while(true) {
            if(tv.flag) {
                System.out.println(Thread.currentThread().getName() + "可以看电视了");
                break;
            }
        }

    }
}



class TV implements Runnable {

    volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        turnOn();
        System.out.println(Thread.currentThread().getName() + "打开电视机了");
    }

    private void turnOn() {
        this.flag = true;
    }
}
