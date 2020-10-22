package com.github.demo.basic.java.io.netty.dubborpc.provider;

import com.github.demo.basic.java.io.netty.dubborpc.common.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shawn
 * @date 2020/10/20
 */
public class HelloServiceImpl implements HelloService {
    static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
    @Override
    public String greeting(String name) {
        logger.info("server: 收到的客户端消息为[{}]", name);
        if(null == name) {
            return "你好客户端，我已经收到你的消息";
        } else {
            return "你好, " + name;
        }
    }
}
