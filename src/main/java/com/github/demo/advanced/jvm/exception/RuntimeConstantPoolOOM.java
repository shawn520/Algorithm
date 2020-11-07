package com.github.demo.advanced.jvm.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出
 * jdk 7 before VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 运行结果：
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
 *
 * 没有效果-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * @author Shawn
 * @date 2020/11/7
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
