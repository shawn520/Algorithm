package com.github.demo.design.action.observer;

/**
 * @author Shawn
 * @date 2020/10/24
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void remove(Observer observer);

    /**
     * 唤醒观察者
     */
    void notifyObserver();

    /**
     * 修改天气信息
     * @param temperature
     * @param pressure
     * @param humility
     */
    void setData(float temperature, float pressure, float humility);

}
