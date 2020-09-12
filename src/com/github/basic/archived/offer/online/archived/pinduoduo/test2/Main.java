package com.github.basic.archived.offer.online.archived.pinduoduo.test2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Shawn
 * @date 2019/7/28
 */
public class Main {

    /*@Test
    public void test() {
        // 功能测试
//        String [] strings = {"CAT", "TIGER", "RPC"};

        // 负值测试
        String [] strings = {"CAT", "RPC"};
        boolean result = fromHead2Tail(strings);
        System.out.println(result);

    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String [] strings = input.split(" ");
        boolean result = fromHead2Tail(strings);
        System.out.println(result);
    }

    public static boolean fromHead2Tail(String[] strings) {
        int length = strings.length;
        if(null == strings || length <2 || length >=1024) {
            return false;
        }
        /*if(length == 1) {
            String str = strings[0];
            return str.charAt(0) == str.charAt(str.length()-1);
        }*/

        HashMap<Character, Stack<String>> map = new HashMap<>(50);

        // 初始化
        for(String str: strings) {
            char cha = str.charAt(0);
            if(cha>'Z' || cha <'A') {
                return false;
            }
            if(map.containsKey(cha)){
                Stack<String> stack = map.get(cha);
                stack.push(str);
            } else {
                Stack<String> stack = new Stack<>();
                stack.push(str);
                map.put(cha, stack);
            }

        }

        String init = strings[0];
        char cha = init.charAt(0);
        Stack<String> stack = map.get(cha);
        String start = stack.pop();
        for(int i = 1; i < length; i++) {
            Character end = start.charAt(start.length()-1);
            if(map.containsKey(end)) {
                Stack<String> temp_stack = map.get(end);
                if(temp_stack.isEmpty()) {
                    return false;
                }
                start = temp_stack.pop();
                map.put(end, temp_stack);
            } else {
                return false;
            }
        }
        if(start.charAt(start.length()-1) == cha) {
            return true;
        }
        return false;
    }
}
