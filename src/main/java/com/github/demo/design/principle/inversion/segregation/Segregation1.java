package com.github.demo.design.principle.inversion.segregation;

/**
 * @author Shawn
 * @date 2020/11/8
 */
public class Segregation1 {
}

interface Interface1 {
    void opration1();
    void opration2();
    void opration3();
    void opration4();
    void opration5();
}

class A implements Interface1 {

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

    @Override
    public void opration4() {
        System.out.println("A: execute opration4");
    }

    @Override
    public void opration5() {
        System.out.println("A: execute opration5");
    }
}

class B implements Interface1 {

    @Override
    public void opration1() {
        System.out.println("B: execute opration1");
    }

    @Override
    public void opration2() {
        System.out.println("B: execute opration2");
    }

    @Override
    public void opration3() {
        System.out.println("B: execute opration3");
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
    void  dependency123(Interface1 interface1) {
        interface1.opration1();
        interface1.opration2();
        interface1.opration3();
    }
}

class D {
    void  dependency145(Interface1 interface1) {
        interface1.opration1();
        interface1.opration4();
        interface1.opration5();
    }
}


