package com.github.demo.design.action.observer;

/**
 * @author Shawn
 * @date 2020/10/24
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Observer observer1 = new CurrentConditions();
        Observer observer2 = new CurrentConditions();
        Subject weatherData = new WeatherData();
        weatherData.registerObserver(observer1);
        weatherData.registerObserver(observer2);
        weatherData.setData(15, 2, 60);
        Thread.sleep(5000);
        weatherData.remove(observer2);
        weatherData.setData(26, 2, 60);

    }
}
