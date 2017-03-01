package google;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class MoveArrayElement {
  public int moveBack(int[] array) {
    boolean[] visited = new boolean[array.length];
    List<Integer> circles = new ArrayList<>();

    for (int i = 0; i < array.length; i++) {
      if (!visited[i]) {
        circles.add(findCircle(array, i, visited));
      }
    }

    return (int) lcm(circles);
  }

  private int findCircle(int[] array, int i, boolean[] visited) {
    int next = array[i];
    visited[i] = true;
    int length = 1;
    while (next != i && length <= array.length) {
      length++;
      visited[next] = true;
      next = array[next];
    }
    if (length < array.length) {
      return length;
    } else {
      return next == i ? length : -1;
    }
  }

  private long lcm(long a, long b) {
    long multiple = a * b;
    return multiple / gcd(a, b);
  }

  private long lcm(List<Integer> list) {
    long result = 1;
    for (Integer aList : list) result = lcm(result, aList);
    return result;
  }

  private long gcd(long a, long b) {
    while (b > 0) {
      long temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
