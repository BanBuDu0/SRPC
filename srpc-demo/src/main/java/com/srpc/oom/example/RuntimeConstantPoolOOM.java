package com.srpc.oom.example;

import java.util.HashSet;
import java.util.Set;

/**
 * JDK 6可用
 * JDK7之后，字符串常量池被移动到了堆区
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString(); System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString(); System.out.println(str2.intern() == str2);

        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}