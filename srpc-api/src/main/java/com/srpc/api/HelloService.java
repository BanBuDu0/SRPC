package com.srpc.api;

/**
 * @author sunyuejun
 */
public interface HelloService {
    /**
     * sayHello
     *
     * @param object HelloObject
     * @return String
     */
    String sayHello(HelloObject object);

    /**
     * say String msg
     *
     * @param msg String msg
     * @return String
     */
    String sayString(String msg);
}
