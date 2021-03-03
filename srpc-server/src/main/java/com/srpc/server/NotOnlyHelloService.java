package com.srpc.server;

import com.srpc.api.NotHelloService;

/**
 * @author sunyuejun
 */
public class NotOnlyHelloService implements NotHelloService {
    @Override
    public String notOnlySayHello(int t) {
        return String.valueOf(t + 1);
    }
}
