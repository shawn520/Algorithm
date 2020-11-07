package com.github.demo.advanced.jvm.exception;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用unsafe分配本机内存，本机直接内存溢出Demo
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * 运行结果:
 * Exception in thread "main" java.lang.OutOfMemoryError
 * 	at sun.misc.Unsafe.allocateMemory(Native Method)
 * 	at com.github.demo.advanced.jvm.exception.DirectMemoryOOM.main(DirectMemoryOOM.java:22)
 *
 * @author Shawn
 * @date 2020/11/7
 */
public class DirectMemoryOOM {

    private static final  int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe)declaredField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
