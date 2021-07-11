package com.github.demo.algorithm.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 * @author Shawn
 * @date 2021/7/11
 */
class RecentCounter {
    Queue<Integer> queue=null;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t-3000)
            queue.poll();
        return queue.size();
    }
}