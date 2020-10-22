package com.github.demo.basic.java.io.netty.dubborpc.provider;

import com.github.demo.basic.java.io.netty.dubborpc.netty.NettyServer;

/**
 * @author Shawn
 * @date 2020/10/20
 */
public class ServerBootStrap {

    public static void main(String[] args) {

        NettyServer.startServer("127.0.0.1", 7000);

    }
}
