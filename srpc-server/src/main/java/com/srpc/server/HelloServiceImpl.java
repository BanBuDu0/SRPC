package com.srpc.server;

import com.srpc.api.HelloObject;
import com.srpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sunyuejun
 */
public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(HelloObject object) {
        logger.info("接收到：{}", object.getMessage());
        return "这是调用的返回值，id=" + object.getId();
    }

    @Override
    public String sayString(String msg) {
        logger.info("接收到 String ：{}", msg);
        return "sayString的返回值: " + msg;
    }
}
