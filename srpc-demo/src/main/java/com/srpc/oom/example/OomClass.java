package com.srpc.oom.example;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 */
public class OomClass {
    private List<OomClass> list = new ArrayList<>();

    public void oomTest() {
        while (true) {
            list.add(new OomClass());
        }
    }

    public static void main(String[] args) {
        OomClass oomClass = new OomClass();
        oomClass.oomTest();
    }
}
