package com.github.demo.design.action.command;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/10/25
 */

public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
