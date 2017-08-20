package google;

import java.util.*;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                Integer current = seq.get(i);
                Integer next = seq.get(i + 1);
                Set<Integer> nextNodes = nodeMap.getOrDefault(current, new HashSet<>());
                if (nextNodes.contains(next)) {
                    continue;
                }
                nextNodes.add(next);
                nodeMap.put(current, nextNodes);

                Integer indegree = degreeMap.getOrDefault(next, 0);
                degreeMap.put(next, indegree + 1);
                degreeMap.put(current, degreeMap.getOrDefault(current, 0));
            }
        }
        if (degreeMap.size() != org.length) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        int[] newSeq = new int[org.length];
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int node = queue.poll();
            newSeq[index++] = node;
            Set<Integer> nextNodes = nodeMap.getOrDefault(node, new HashSet<>());
            for (Integer nextNode : nextNodes) {
                int indegree = degreeMap.get(nextNode) - 1;
                if (indegree == 0) {
                    queue.offer(nextNode);
                }
                degreeMap.put(nextNode, indegree);
            }
        }
        return Arrays.equals(org, newSeq);
    }
}
