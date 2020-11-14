package com.github.demo.design.structure.decorator;

/**
 * @author Shawn
 * @date 2020/11/14
 */
public class Main {

    public static void main(String[] args) {
        //点一份美式咖啡
        Drink order = new LongBlack();
        System.out.println("点一份美式咖啡花费" + order.cost());

        //再加一份巧克力
        order = new Chocolate(order);
        System.out.println("点一份美式咖啡, 再加一份巧克力花费" + order.cost());

        //再加一份巧克力
        order = new Chocolate(order);
        System.out.println("点一份美式咖啡, 再加两份巧克力花费" + order.cost());

        //再加一份牛奶
        order = new Milk(order);
        System.out.println("点一份美式咖啡, 再加两份巧克力, 一份牛奶花费" + order.cost());
    }
}
