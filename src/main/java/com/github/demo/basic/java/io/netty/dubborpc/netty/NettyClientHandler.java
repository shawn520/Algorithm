package com.github.demo.basic.java.io.netty.dubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author Shawn
 * @date 2020/10/20
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context; //上下文
    private String result; //返回的结果

    private String para; //客户端调用方法时，传入的参数

    /**
     * 与服务器建立连接后，就会被调用，这个方法第一个被调用(1)
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive被调用");
        context = ctx;
    }

    /**
     * 读取服务器传来的结果，（4）
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead被调用");
        result = msg.toString();
        notify();   //唤醒等待的线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    /**
     * 被代理对象调用，发送数据给服务器, wait -->等待被唤醒--》返回结果（3） -（5）
     * @return
     * @throws Exception
     */
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call被调用");
        context.writeAndFlush(para);
        // 进行wait
        wait(); //等待channelRead方法获取服务器的结果后，唤醒
        System.out.println("call2 被调用");
        return result;
    }

    /**
     * （2）
     * @param para
     */
    public void setPara(String para) {
        System.out.println("setPara被调用");
        this.para = para;
    }


}
