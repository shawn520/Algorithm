package com.github.demo.advanced.jvm.exception;

/**
 * Java 虚拟机栈溢出
 * Vm Args: -Xss128k
 * 用Throwable而不用Exception的原因？因为抛出的是StackOverflowError，Exception不能捕获
 *
 * 运行结果：
 * java.lang.StackOverflowError
 * 	at com.github.demo.advanced.jvm.exception.JavaVMStackOverFlowError.stackLeak(JavaVMStackOverFlowError.java:15)
 * @author Shawn
 * @date 2020/11/7
 */
public class JavaVMStackOverFlowError {

    private int stackLength = 0;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackOverFlowError javaVMStackOverFlowError = new JavaVMStackOverFlowError();
        try {
            javaVMStackOverFlowError.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack Length: " + javaVMStackOverFlowError.stackLength);
            e.printStackTrace();
        }
    }
}
