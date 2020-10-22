package com.github.demo.basic.java.io.netty.dubborpc.netty;

import com.github.demo.basic.java.io.netty.dubborpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shawn
 * @date 2020/10/20
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客服端发送的消息，并调用服务
        logger.info("msg = {}", msg);
        //客户端在调用服务器的api时，我们需要定义一个协议
        //比如我们要求每次发消息时，都必须以某个字符串开头
        if(msg.toString().startsWith("HelloService#hello#")) {
            String result = new HelloServiceImpl().greeting(msg.toString().substring(msg.toString().lastIndexOf("#")+1));
            ctx.writeAndFlush(result);

        }


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
