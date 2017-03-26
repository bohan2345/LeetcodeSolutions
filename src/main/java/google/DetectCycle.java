package google;

import utils.GraphNode;

import java.util.*;

/**
 * <p>
 * Created by Bohan Zheng on 6/30/2016.
 *
 * @author Bohan Zheng
 */
public class DetectCycle {
  //topological sort
  public boolean detectCycle(List<GraphNode[]> edges) {
    Map<GraphNode, Integer> indegreeMap = new HashMap<>(edges.size());
    for (GraphNode[] edge : edges) {
      edge[0].adjcents.add(edge[1]);
      if (indegreeMap.containsKey(edge[1])) {
        indegreeMap.put(edge[1], indegreeMap.get(edge[1]) + 1);
      } else {
        indegreeMap.put(edge[1], 1);
      }
      if (!indegreeMap.containsKey(edge[0])) {
        indegreeMap.put(edge[0], 0);
      }
    }
    Queue<GraphNode> set = new LinkedList<>();
    indegreeMap.forEach((node, indegree) -> {
      if (indegree == 0) {
        set.add(node);
      }
    });
    int count = 0;
    while (!set.isEmpty()) {
      GraphNode n = set.poll();
      count++;
      for (GraphNode adj : n.adjcents) {
        int indegree = indegreeMap.get(adj) - 1;
        if (indegree == 0) {
          set.offer(adj);
        } else {
          indegreeMap.put(adj, indegree);
        }
      }
    }
    return indegreeMap.size() != count;
  }

  //DFS
  public boolean detectCycle(GraphNode... nodes) {
    // not contain -> unvisited, 1 -> in progress, 2 -> done
    Map<GraphNode, Integer> visited = new HashMap<>();
    for (GraphNode node : nodes) {
      if (!visited.containsKey(node) && dfs(node, visited)) return true;
    }
    return false;
  }

  private boolean dfs(GraphNode node, Map<GraphNode, Integer> visited) {
    visited.put(node, 1);
    for (GraphNode successor : node.adjcents) {
      if (visited.containsKey(successor) && visited.get(successor) == 1) {
        return true;
      } else if (!visited.containsKey(successor) && dfs(successor, visited)) {
        return true;
      }
    }
    visited.put(node, 2);
    return false;
  }
}