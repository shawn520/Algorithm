package com.github.demo.designPattern.action.observer;

/**
 * @author Shawn
 * @date 2020/10/24
 */
public interface Observer {

    void update(float temperature, float pressure, float humility);
}
