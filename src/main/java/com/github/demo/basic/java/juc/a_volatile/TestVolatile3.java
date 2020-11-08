package com.github.demo.basic.java.juc.a_volatile;

/**
 * @author Shawn
 * @date 2020/11/8
 */
public class TestVolatile3 {

    public static void main(String[] args) {
        Button button = new Button();
        new Thread(button).start();
        while(true) {
            if(button.flag) {
                System.out.println("________");
                break;
            }
        }

    }
}



class Button implements Runnable {

    volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        turnOn();
        System.out.println("打开电视机了");
    }

    private void turnOn() {
        this.flag = true;
    }
}
