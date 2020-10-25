package com.github.demo.design.action.command;

/**
 * @author Shawn
 * @date 2020/10/25
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
