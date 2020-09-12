package com.github.demo.basic.java.concurent.chapter4.pool.thread;

/**
 * @author Shawn
 * @date 2019/10/11
 */
public class Main {
    public static void main(String[] args) {
        SimpleHttpServer.setBasePath("C:\\Users\\Shawn\\Downloads");
        try {
            SimpleHttpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
