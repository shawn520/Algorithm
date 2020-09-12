package com.github.basic.leetcode.graph.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shawn
 * @date 2019/8/14
 */
public class Solution {
    public Node cloneGraph(Node node) {
        if(null == node) {
            return null;
        }

        HashMap<Node, Integer> map = new HashMap<>();
        Node result = dfs(node, map);
        return result;

    }

    private Node dfs(Node node, HashMap<Node, Integer> map) {
        Node cloneNode = null;
        if(!map.containsKey(node)) {
            map.put(node, 1);
            List<Node> cloneNeighbors = new ArrayList<>();
            for(Node neighbor : node.neighbors) {
                Node cloneNeighbor = null;
                if(!map.containsKey(neighbor)) {
                    cloneNeighbor = dfs(neighbor, map);
                } else {

                }
                cloneNeighbors.add(cloneNeighbor);
            }
            cloneNode = new Node(node.val, cloneNeighbors);
        }
        return cloneNode;

    }


}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
