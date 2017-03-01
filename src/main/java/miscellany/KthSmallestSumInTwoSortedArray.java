package miscellany;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <p>
 * Created by Bohan Zheng on 11/23/16.
 *
 * @author Bohan Zheng
 */
public class KthSmallestSumInTwoSortedArray {
  public int find(int[] A, int[] B, int k) {
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
    int n = A.length, m = B.length;
    int i = 0, j = 0;
    queue.offer(new Node(A[i] + B[j], i, j));
    Set<Node> set = new HashSet<>(2 * k);
    while (k > 1 && !queue.isEmpty()) {
      Node node = queue.poll();
      k--;
      i = node.x;
      j = node.y;
      if (i + 1 < n) {
        Node below = new Node(A[i + 1] + B[j], i + 1, j);
        if (!set.contains(below)) {
          set.add(below);
          queue.offer(below);
        }
      }
      if (j + 1 < m) {
        Node right = new Node(A[i] + B[j + 1], i, j + 1);
        if (!set.contains(right)) {
          set.add(right);
          queue.offer(right);
        }
      }
    }
    if (queue.isEmpty()) {
      throw new IllegalArgumentException("K is too big");
    } else {
      return queue.peek().val;
    }
  }

  class Node {
    int val;
    int x;
    int y;

    Node(int val, int x, int y) {
      this.val = val;
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return x * 10 + y;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Node)) {
        return false;
      }
      Node node = (Node) obj;
      return x == node.x && y == node.y;
    }
  }
}
