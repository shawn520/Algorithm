package com.github.demo.basic.java.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public void test() {
//        System.out.println("hello ");
//        testFilter();
//        testMap();
//        testLimit();
//        testSorted();
//        testDistinct();
        testAll();
    }

    public void testStream() {
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "hello", "helloworld", "hollis");
        Stream<String> stream = strings.stream();
    }

    public void testFilter() {
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
        //Hollis, , HollisChuang, H, hollis
    }

    public void testMap() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map( i -> i*i).forEach(System.out::println);
        //9,4,4,9,49,9,25
    }

    /**
     * limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素。以下代码片段使用 limit 方法保理4个元素：
     */
    public void testLimit() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().limit(4).forEach(System.out::println);
        //3,2,2,3
    }


    /**
     * sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法进行排序：
     */
    public void testSorted() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().sorted().forEach(System.out::println);
        //2,2,3,3,3,5,7
    }

    /**
     * distinct主要用来去重，以下代码片段使用 distinct 对元素进行去重：
     */
    public void testDistinct() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().distinct().forEach(System.out::println);
        //3,2,7,5
    }

    public void testAll() {
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        strings.stream().filter(string -> string.length()<= 6).map(String::length).sorted().limit(3)
                .distinct().forEach(System.out::println);
    }
}
