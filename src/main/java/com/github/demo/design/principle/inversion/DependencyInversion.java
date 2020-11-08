package com.github.demo.design.principle.inversion;

/**
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



class Email {
    public String getInfo() {
        return "email info";
    }
}

class Message {
    public String getInfo() {
        return "massage info";
    }
}


/**
 * 每接收多一种消息，微信、短信、邮件等，就得增加一种方法，而且会依赖这些类。
 *
 * 改进：依赖接口，每种消息都实现接口。
 *
 * person类
 */
class Person {

    public void receive(Email email) {
        System.out.println(email.getInfo());
    }

    public void receive(Message message) {
        System.out.println(message.getInfo());
    }
}
