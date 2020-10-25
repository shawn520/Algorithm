package com.github.demo.design.structure.proxy;

/**
 * @author Shawn
 * @date 2019/7/5
 */

public class RealImage implements Image {



    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);

    }



    @Override
    public void display() {
        System.out.println("Displaying:" + fileName);
    }

    public void loadFromDisk(String fileName) {
        System.out.println("Loading from disk:" + fileName);

    }

}
