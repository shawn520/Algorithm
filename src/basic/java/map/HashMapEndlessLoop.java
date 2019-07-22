package basic.java.map;

import java.util.HashMap;

/**
 * hashMap 死链问题
 * @author Shawn
 * @date 2019/7/22
 */
public class HashMapEndlessLoop {
    private static final Integer THREAD_NUM = 10;
    private static HashMap<Long, EasyCoding> map = new HashMap<>();

    public static void main(String[] args) {
        for(int i = 0; i<THREAD_NUM; i++) {
            new Thread() {
                @Override
                public void run() {
                    map.put(System.nanoTime(), new EasyCoding());
                }
            }.start();
        }

        System.out.println(map.size());
    }


}

class EasyCoding{}
