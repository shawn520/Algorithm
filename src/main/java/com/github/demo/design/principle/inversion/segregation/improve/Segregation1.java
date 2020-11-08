package com.github.demo.design.principle.inversion.segregation.improve;

/**
 * @author Shawn
 * @date 2020/11/8
 */
public class Segregation1 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        C c = new C();
        D d= new D();

        c.dependency1(a);
        c.dependency2(a);
        c.dependency3(a);
        d.dependency1(b);
        d.dependency4(b);
        d.dependency5(b);
    }




}

interface interface1 {
    void opration1();
}

interface Interface2 {
    void opration2();
    void opration3();
}

interface Interface3 {
    void opration4();
    void opration5();
}

class A implements interface1, Interface2 {

    @Override
    public void opration1() {
        System.out.println("A: execute opration1");
    }

    @Override
    public void opration2() {
        System.out.println("A: execute opration2");
    }

    @Override
    public void opration3() {
        System.out.println("A: execute opration3");
    }

}

class B implements interface1, Interface3 {

    @Override
    public void opration1() {
        System.out.println("B: execute opration1");
    }

    @Override
    public void opration4() {
        System.out.println("B: execute opration4");
    }

    @Override
    public void opration5() {
        System.out.println("B: execute opration5");
    }
}

class C {

    public C() {

    }

    public void  dependency1(interface1 interface1) {
        interface1.opration1();
    }

    public void  dependency2(Interface2 interface2) {
        interface2.opration2();
    }

    public void  dependency3(Interface2 interface2) {
        interface2.opration3();
    }
}

class D {
    public void  dependency1(interface1 interface1) {
        interface1.opration1();
    }

    public void  dependency4(Interface3 interface3) {
        interface3.opration4();
    }

    public void  dependency5(Interface3 interface3) {
        interface3.opration5();
    }
}
