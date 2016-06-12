package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <p>
 * Created by Bohan Zheng on 6/12/2016.
 *
 * @author Bohan Zheng
 */
public class TopologicalSort {
    public List<Character> alienDictionary(List<String> strs) {
        Map<Character, DAGNode<Character>> map = new HashMap<>();
        List<DAGNode<Character>> nodes = new ArrayList<>();
        for (String str : strs) {
            DAGNode<Character> node = null;
            if (map.containsKey(str.charAt(0))) {
                node = map.get(str.charAt(0));
            } else {
                node = new DAGNode<>(str.charAt(0));
                map.put(str.charAt(0), node);
                nodes.add(node);
            }
            for (int i = 1; i < str.length(); i++) {
                DAGNode<Character> nextNode = null;
                if (map.containsKey(str.charAt(i))) {
                    nextNode = map.get(str.charAt(i));
                } else {
                    nextNode = new DAGNode<>(str.charAt(i));
                    map.put(str.charAt(i), nextNode);
                    nodes.add(nextNode);
                }
                node.neighbors.add(nextNode);
                nextNode.indegree += 1;
            }
        }
        return topologicalSort(nodes);
    }

    private List<Character> topologicalSort(List<DAGNode<Character>> nodes) {
        List<Character> res = new ArrayList<>();
        Queue<DAGNode<Character>> queue = new LinkedList<>();
        int nodeCount = 0;
        for (DAGNode<Character> n : nodes) {
            if (n.indegree == 0) {
                queue.offer(n);
            }
        }
        while (!queue.isEmpty()) {
            DAGNode<Character> deletedNodes = queue.poll();
            res.add(deletedNodes.value);
            nodeCount++;
            for (DAGNode<Character> node : deletedNodes.neighbors) {
                node.indegree -= 1;
                if (node.indegree == 0) {
                    queue.offer(node);
                }
            }
        }
        return nodeCount == nodes.size() ? res : null;
    }

    public static class DAGNode<E> {
        public List<DAGNode<E>> neighbors;
        public E value;
        public int indegree;

        public DAGNode(E value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
            this.indegree = 0;
        }
    }
}
