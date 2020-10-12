package com.github.demo.basic.java.io.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Shawn
 * @date 2020/9/8
 */
public class NettyServer {
  public static void main(String[] args) throws InterruptedException {

    //创建 BossGroup 和  WorkerGroup

    //1. 创建两个线程组bossGroup 和WorkerGroup

    //2. bossGroup只是处理连接请求，真正的和客户端业务处理，会交给WorkerGroup完成

    //3. 两个都是无限循环
      // 4. bossGroup和workerGroup含有的子线程数默认的个数是cpu核数*2
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup(8);

    try {
        //创建服务器端启动对象，配置启动参数
        ServerBootstrap bootstrap = new ServerBootstrap();

        //使用链式编程进行设置
        bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                .channel(NioServerSocketChannel.class)    //使用NioServerSocketChannel作为服务器的通道实现
                .option(ChannelOption.SO_BACKLOG, 128)  //设置线程队列得到连接个数
                .childOption(ChannelOption.SO_KEEPALIVE, true)  //设置保持活动连接状态
                .childHandler(new ChannelInitializer<SocketChannel>() { //创建一个通道初始化对象（匿名对象）
                    //给Pipeline设置处理器
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        System.out.println("客户socketChannel hashcode: " + ch.hashCode());
                        // 使用一个集合管理socketChannel, 在需要推送消息时，可以将业务加入到各个channel
                        // 对应的nioEventLoop的taskQueue后者scheduleTaskQueue
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                }); //给我们的workerGroup的EventLoop对应的管道设置处理器
        System.out.println(".....服务器 is ready....");
        //绑定一个端口并且同步，生成了一个channelFuture对象
        //启动服务器（并绑定端口）
        ChannelFuture channelFuture = bootstrap.bind(6668).sync();
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(channelFuture.isSuccess()) {
                    System.out.println("监听端口6668 成功");
                } else {
                    System.out.println("监听端口6668 失败");
                }
            }
        });


        //对关闭通道进行监听
        channelFuture.channel().closeFuture().sync();
    } finally {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }



  }
}
