package com.github.demo.design.structure.decorator;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;

/**
 * @author Shawn
 * @date 2020/11/14
 */
public class JDKDecoratorApplication {

    public static void main(String[] args) throws Exception {
        FilterInputStream filterInputStream = new DataInputStream(new FileInputStream(""));
    }
}
