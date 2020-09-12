package com.github.designPattern.creation.abstractfactory.color;

/**
 * @author Shawn
 * @date 2019/7/3
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("fill blue.");
    }
}
