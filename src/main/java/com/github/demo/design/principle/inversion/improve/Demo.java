package com.github.demo.design.principle.inversion.improve;

/**
 * 依赖关系传递的三种方式
 * @author Shawn
 * @date 2020/11/8
 */
public class Demo {
    public static void main(String[] args) {

        //1. 通过接口依赖,见另外一个例子

        //2. 通过构造函数依赖
        Monitor monitor = new Monitor(new ChuangWei());
        monitor.turnOn();

        //3. 通过set方法依赖
        monitor.set(new Xiaomi());
        monitor.turnOn();
    }
}

interface ITV {
    String open();
}


class ChuangWei implements ITV {

    @Override
    public String open() {
        return "打开创维电视";
    }
}

class Xiaomi implements ITV {

    @Override
    public String open() {
        return "打开小米电视";
    }
}

class Monitor {

    ITV itv;

    Monitor() {

    }

    Monitor(ITV itv) {
        this.itv = itv;
    }

    void turnOn() {
        System.out.println(itv.open());
    }

    void set(ITV itv) {
        this.itv = itv;
    }
}