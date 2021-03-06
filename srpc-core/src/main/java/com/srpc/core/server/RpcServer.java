package com.srpc.core.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class RpcServer {

    private final ExecutorService threadPool;
    public static final Logger logger = LoggerFactory.getLogger(RpcServer.class);

    public RpcServer() {
        int corePoolSize = 4;
        int maxPoolSize = 20;
        long keepAliveTime = 60;
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<>(100);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadPool = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                workingQueue,
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    public void register(Object service, int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            logger.info("服务器正在启动...");
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                logger.info("客户端连接！Ip为：" + socket.getInetAddress());
                threadPool.execute(new WorkThread(socket, service));
            }
        } catch (IOException e) {
            logger.info("连接错误: ", e);
        }
    }
}
