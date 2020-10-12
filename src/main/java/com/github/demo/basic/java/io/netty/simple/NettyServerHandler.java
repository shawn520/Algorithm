package com.github.demo.basic.java.io.netty.simple;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


/**
 * 我们自定义一个handler需要继承netty规定好的某个handler适配器
 * 这时我们自定义的handler才能称为一个handler
 * @author Shawn
 * @date 2020/9/15
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

    /**
     * 读取数据的事件（这里我们可以读取客户端发送的消息）
     * @param ctx 上下文对象，含有管道pipeline，通道channel，地址
     * @param msg 客户端发送的数据，默认object
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //比如说我们这里有一个非常耗时时间的业务->异步执行->
        // 提交该channel对应的NIOEventLoop的taskQueue中
        //解决方案一 用户程序自定义的普通任务
        for(int i=0; i<5; i++) {
            ctx.channel().eventLoop().execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端2", CharsetUtil.UTF_8));
                    } catch (InterruptedException e) {
                        logger.info("发生异常:{}", e.getMessage());
                    }


                }
            });
        }

        //2. 用户自定义定时任务 -> 该任务提交到scheduleTaskQueue中
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5* 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端4", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    logger.info("发生异常:{}", e.getMessage());
                }


            }
        }, 5, TimeUnit.SECONDS);



        System.out.println("go on...");






//        System.out.println("服务器读取线程：" + Thread.currentThread().getName());
//
//        System.out.println("server ctx = " + ctx);
//        //将msg转换成一个ByteBuf, ByteBuf是Netty提供的，不是NIO的ByteBuffer
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("客户端发送消息是：" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址是：" + ctx.channel().remoteAddress());

    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写到缓存并刷新
        //一般讲，我们对发送的数据进行编码

        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端1~", CharsetUtil.UTF_8));
    }

    //处理异常，一般需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
