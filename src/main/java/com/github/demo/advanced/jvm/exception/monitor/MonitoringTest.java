package com.github.demo.advanced.jvm.exception.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用JConsole监视jvm
 *
 * VM Args: -Xms100m -Xmx100m -XX:+UseSerialGC
 *
 * @author Shawn
 * @date 2020/11/7
 */
public class MonitoringTest {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap (int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            //稍作延时，令监视曲线变化更明显
            Thread.sleep(50);
            list.add(new OOMObject());
            System.out.println(i);
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
