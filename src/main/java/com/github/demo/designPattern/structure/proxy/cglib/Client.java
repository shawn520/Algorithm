package com.github.demo.designPattern.structure.proxy.cglib;

/**
 * @author Shawn
 * @date 2020/10/13
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao target = new TeacherDao();
        // 获取代理对象，并且将目标对象传递给代理对象
        TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();
        // 执行代理对象的方法，触发interceptor，从而实现对目标对象的调用
        proxyInstance.teach();
    }
}
