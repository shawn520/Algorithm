package com.github.demo.advanced.jvm.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * vm Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 运行结果：
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to java_pid24816.hprof ...
 * Heap dump file created [28223136 bytes in 0.073 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.util.Arrays.copyOf(Arrays.java:3210)
 * 	at java.util.Arrays.copyOf(Arrays.java:3181)
 * 	at java.util.ArrayList.grow(ArrayList.java:265)
 * 	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
 * 	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
 * 	at java.util.ArrayList.add(ArrayList.java:462)
 * 	at com.github.demo.advanced.jvm.exception.HeapOOM.main(HeapOOM.java:21)
 *
 * Process finished with exit code 1
 *
 * @author Shawn
 * @date 2020/11/7
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
