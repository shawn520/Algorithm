package com.github.demo.designPattern.action.observer;

/**
 * @author Shawn
 * @date 2020/10/24
 */
public class CurrentConditions implements Observer {
    private float temperature;
    private float pressure;
    private float humility;

    @Override
    public void update(float temperature, float pressure, float humility) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humility = humility;
        display();
    }

    public void display() {
        System.out.println("current temperature: " + temperature + "centigrade");
        System.out.println("current pressure: " + pressure + "P");
        System.out.println("current humility: " + humility + "percent");
        System.out.println("-------------------------------");
    }
}
