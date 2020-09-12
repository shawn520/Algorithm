package com.github.basic.java.generic;

/**
 * 泛型示例
 * 使用泛型的好处：
 * 放置的是什么，返回的就是什么，且合并同类型的处理代码，使代码复用。
 *
 * @author Shawn
 * @date 2019/7/20
 */
public class Stove {

    public static <T> T head(T food) {
        System.out.println(food + " is done");
        return food;
    }

    public static void main(String[] args) {
        Meat meat = new Meat();
        head(meat);

        Soup soup = new Soup();
        head(soup);
    }

    private static class Meat {
    }

    private static class Soup {
    }
}
