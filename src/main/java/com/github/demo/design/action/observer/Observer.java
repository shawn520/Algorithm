package com.github.demo.design.action.observer;

/**
 * @author Shawn
 * @date 2020/10/24
 */
public interface Observer {

    void update(float temperature, float pressure, float humility);
}
