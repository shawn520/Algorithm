package com.github.demo.design.action.command;

/**
 * @author Shawn
 * @date 2020/10/25
 */
public class Stock {

    private String name = "A company";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
