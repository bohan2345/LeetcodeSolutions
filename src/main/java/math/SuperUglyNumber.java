package math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>
 * Created by Bohan Zheng on 10/23/16.
 *
 * @author Bohan Zheng
 */
public class SuperUglyNumber {
  public int nthSuperUglyNumber(int n, int[] primes) {
    Queue<Integer> Q = new PriorityQueue<>();
    HashSet<Integer> inQ = new HashSet<>();
    for (int prime : primes) {
      Q.add(prime);
      inQ.add(prime);
    }
    int number = 1;
    for (int i = 1; i < n; i++) {
      number = Q.poll();
      for (int prime : primes) {
        if (!inQ.contains(prime * number)) {
          Q.add(number * prime);
          inQ.add(number * prime);
        }
      }
    }
    return number;
  }
}
