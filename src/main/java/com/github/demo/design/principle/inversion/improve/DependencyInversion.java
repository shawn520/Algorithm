package com.github.demo.design.principle.inversion.improve;

/**
 * 设计模式六大原则：依赖反转。依赖于接口（抽象），而不是依赖具体。
 * @author Shawn
 * @date 2020/11/8
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Message());
    }
}

interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {

    @Override
    public String getInfo() {
        return "email info";
    }
}

class Message implements IReceiver {

    @Override
    public String getInfo() {
        return "message info";
    }
}


class Person {

    /**
     * 依赖抽象的接口
     * @param receiver
     */
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
