package com.github.basic.java.jvm;

import java.util.Random;

/**
 * @author Shawn
 * @date 2020/8/16
 */
public class Demo02 {
  public static void main(String[] args) {
//    long maxMemory = Runtime.getRuntime().maxMemory();
//    long totalMemory = Runtime.getRuntime().totalMemory();
//    System.out.println("MAX_MEMORY = " + maxMemory + "(字节) " + (maxMemory/(double)1024/1024) + "MB");
//    System.out.println("TOTAL_MEMORY = " + maxMemory + "(字节) " + (totalMemory/(double)1024/1024) + "MB");
    String str = "www.github.com";
    while (true) {
      str += str + new Random().nextInt(8888888) + new Random(9999999);
    }
  }
}
