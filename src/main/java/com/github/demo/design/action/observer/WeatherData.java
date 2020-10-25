package com.github.demo.design.action.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 核心
 * 包含最新的天气情况信息
 * 含有CurrentConditions对象
 * 当数据更新时，主动调用所有CurrentConditions对象的update方法。
 * @author Shawn
 * @date 2020/10/24
 */
public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humility;
    List<Observer> observers = new ArrayList<>();

    @Override
    public void setData(float temperature, float pressure, float humility) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humility = humility;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observers) {
            observer.update(temperature, pressure, humility);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumility() {
        return humility;
    }

    public void setHumility(float humility) {
        this.humility = humility;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
}
