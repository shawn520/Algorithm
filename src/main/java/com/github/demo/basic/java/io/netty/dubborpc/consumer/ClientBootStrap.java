package com.github.demo.basic.java.io.netty.dubborpc.consumer;

import com.github.demo.basic.java.io.netty.dubborpc.common.HelloService;
import com.github.demo.basic.java.io.netty.dubborpc.netty.NettyClient;

/**
 * @author Shawn
 * @date 2020/10/21
 */
public class ClientBootStrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {
        //创建一个消费者
        NettyClient customer = new NettyClient();

        //创建代理对象
        HelloService helloService = (HelloService) customer.getBean(HelloService.class, providerName);


        for(;;) {
            Thread.sleep(5 * 1000);
            //通过代理对象调用服务提供者的方法
            String result = helloService.greeting("shawn");
            System.out.println("调用的结果为" + result);

        }

    }
}
