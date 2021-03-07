package com.srpc.oom.example;

/**
 * -Xss1g
 */
public class JavaVMStackOverFlow {
    //如果不指定-Xss128K, 栈深度有35364；指定128k，栈深度为990；指定为5g时，栈深度为67076295
    //                                                                        64989471
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOverFlow oom = new JavaVMStackOverFlow();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
