package com.github.demo.designPattern.structure.proxy.dynamic;

/**
 * @author Shawn
 * @date 2019/10/12
 */
public class Client {

    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();

        ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyInstance();
//        System.out.println("proxyInstance = " + proxyInstance);
        //proxyInstance = class com.sun.proxy.$Proxy0 内存中动态生成的代理对象
//        System.out.println("proxyInstance = " + proxyInstance.getClass());
//        proxyInstance.teach();
        proxyInstance.sayHello("tom");

    }
}
