package com.srpc.jdkproxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxyFactory {
    static class ExampleInvocationHandler implements InvocationHandler {
        private final Object object;

        public ExampleInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //调用方法之前，我们可以添加自己的操作
            Object result = null;
            switch (method.getName()) {
                case "send":
                    System.out.println("before method " + method.getName());
                    result = method.invoke(this.object, args);
                    //调用方法之后，我们同样可以添加自己的操作
                    System.out.println("after method " + method.getName());
                    break;
                case "get":
                    System.out.println("get");
                default:
                    break;
            }
            return result;
        }
    }


    public static Object getProxy(Object target) {
        System.out.println(target.getClass().getClassLoader());
        System.out.println(Arrays.toString(target.getClass().getInterfaces()));
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ExampleInvocationHandler(target)
        );
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("aaa");
    }
}
