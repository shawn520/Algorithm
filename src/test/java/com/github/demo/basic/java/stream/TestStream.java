package com.github.demo.basic.java.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/8/3
 */
public class TestStream {

  @Test
  public void test() {
    List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
    strings.stream().filter(p -> p.length()<7)
            .map(p -> p.length())
            .sorted()
            .limit(3)
            .distinct()
            .forEach(System.out :: println);
  }
}
