package bfs;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = buildGraph(edges);
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        int current = 0;
        int next = 0;
        for (int node : graph.keySet()) {
            if (graph.get(node).size() == 1) {
                queue.offer(node);
                current++;
            }
        }
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            current--;
            for (int num : graph.get(node)) {
                Set<Integer> nextSet = graph.get(num);
                nextSet.remove(node);
                if (nextSet.size() == 1) {
                    queue.offer(num);
                }
            }
            if (current == 0) {
                current = next;
                next = 0;
                res = level;
                level = new ArrayList<>();
            }
        }
        return res;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> next = graph.getOrDefault(edge[0], new HashSet<>());
            next.add(edge[1]);
            graph.putIfAbsent(edge[0], next);
            Set<Integer> next2 = graph.getOrDefault(edge[1], new HashSet<>());
            next2.add(edge[0]);
            graph.putIfAbsent(edge[1], next2);
        }
        return graph;
    }
}
