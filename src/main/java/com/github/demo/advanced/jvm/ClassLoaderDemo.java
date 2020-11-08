package com.github.demo.advanced.jvm;

/**
 * 类加载器
 * 系统类加载器：加载核心类库，c++写的
 * 扩展类加载器：加载/lib/ext/目录下的文件
 * 应用类加载器：加载classpath目录下的文件
 * 双亲委派模型：当前类加载器一直回溯到系统类加载器，父类加载器如果可以加载则由父类加载器加载，若不能则交由子类加载器加载。
 * 这样做的好处：保证不会出现重复加载的情况。
 * @author Shawn
 * @date 2020/8/13
 */
public class ClassLoaderDemo {
  public static void main(String[] args) {
    Object obj = new Object();
    ClassLoaderDemo demo01 = new ClassLoaderDemo();
    System.out.println(obj.getClass().getClassLoader());
    System.out.println("-----------");
    System.out.println(demo01.getClass().getClassLoader().getParent().getParent());
    System.out.println(demo01.getClass().getClassLoader().getParent().toString());
    System.out.println(demo01.getClass().getClassLoader().toString());
    System.out.println("-----------");
  }
}
