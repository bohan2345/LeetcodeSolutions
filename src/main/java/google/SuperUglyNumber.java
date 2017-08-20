package google;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(n1 -> n1.value));
        int[] uglyNums = new int[n + 1];
        uglyNums[0] = 1;
        int i = 1;
        for (int prime : primes) {
            q.offer(new Node(prime, 0, prime));
        }
        while (n > 2) {
            Node node = q.poll();
            uglyNums[i] = node.value;
            q.offer(new Node(node.prime, node.index + 1, node.prime * uglyNums[node.index + 1]));
            while (node.value == q.peek().value) {
                node = q.poll();
                q.offer(new Node(node.prime, node.index + 1, node.prime * uglyNums[node.index + 1]));
            }
            i++;
            n--;
        }
        return q.poll().value;
    }

    class Node {
        int prime;
        int index;
        int value;

        Node(int prime, int index, int value) {
            this.prime = prime;
            this.index = index;
            this.value = value;
        }
    }
}
