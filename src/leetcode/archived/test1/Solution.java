package leetcode.archived.test1;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph,
 * return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * @author Shawn
 * @date 2019/8/26
 */
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
class Solution {
    public Node cloneGraph(Node node) {
        if(null == node) return null;
        Map<Integer, Node> map = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, clone);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node old = queue.remove();
            for(Node neighbor: old.neighbors) {
                if(!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val,new Node(neighbor.val, new ArrayList<Node>()));
                    queue.add(neighbor);
                }
                map.get(old.val).neighbors.add(map.get(neighbor.val));

            }
        }
        return map.get(node.val);

    }
}
