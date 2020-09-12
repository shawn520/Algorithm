package com.github.basic.leetcode.graph.test2;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2019/8/15
 */
class Solution {

    @Test
    public void test() {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> results = findMinHeightTrees(n, edges);
        System.out.println(results.toString());
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> [] nodes = new ArrayList[n];
        for(int i=0; i<n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int [] edge : edges) {
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        List<Integer> result = new ArrayList<>();
        int min = n;
        for(int i = 0; i<n; i++) {
            boolean [] visited = new boolean[n];
            for(int j= 0; j<n; i++) {
                visited[j] = false;
            }
            int depth = dfs(nodes, visited, i);
            if(depth < min) {
                min = depth;
                result = new ArrayList<>();
                result.add(i);
            } else if(depth == min) {
                result.add(i);
            }
        }
        return result;

    }

    public int dfs(List<Integer> [] nodes, boolean [] visited, int i) {

        if(visited[i]) {
            return 0;
        }
        int max = 0;
        visited[i] = true;
        for(int j : nodes[i]) {
            int depth = dfs(nodes, visited, j);
            if(depth > max) {
                max = depth;
            }
        }
        return max+1;

    }
}
