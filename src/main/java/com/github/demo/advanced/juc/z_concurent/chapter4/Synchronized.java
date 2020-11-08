package com.github.demo.advanced.juc.z_concurent.chapter4;

/**
 * 使用javap工具查看生成的class文件信息来分析synchronized关键字的实现细节
 * @author liuxiao_sx
 * @date 2019/4/17
 */
public class Synchronized {
    //对Synchronized class对象进行加锁
    public static void main(String[] args) {
        synchronized (Synchronized.class) {

        }
        m();

    }
    public static synchronized void m() {

    }
}

/**
 * javap -v Synchronized.class
 */

/*
public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1
         0: ldc           #2                  // class com.github.basic.others/z_concurent/chapter4/Synchronized
         2: dup
         3: astore_1
         4: monitorenter
         5: aload_1
         6: monitorexit
         7: goto          15
        10: astore_2
        11: aload_1
        12: monitorexit
        13: aload_2
        14: athrow
        15: return
      Exception table:
         from    to  target type
             5     7    10   any
            10    13    10   any
      LineNumberTable:
        line 11: 0
        line 13: 5
        line 15: 15
      StackMapTable: number_of_entries = 2
        frame_type = 255 //full_frame
          offset_delta = 10
                  locals = [ class "[Ljava/lang/String;", class java/lang/Object ]
        stack = [ class java/lang/Throwable ]
        frame_type = 250 //chop
        offset_delta = 4

public static synchronized void m();
        descriptor: ()V
        flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
        Code:
        stack=0, locals=0, args_size=0
        0: return
 */
