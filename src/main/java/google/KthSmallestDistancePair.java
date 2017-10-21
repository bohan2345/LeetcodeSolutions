package google;

import com.google.common.collect.ImmutableList;

import java.util.*;

public class KthSmallestDistancePair {
    public int[] getKthPair(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(pair -> Math.abs(pair[0] - pair[1])));
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                q.offer(new int[]{nums[i], nums[j]});
            }
        }
        int[] res = {};
        for (; k > 0; k--) {
            res = q.poll();
        }
        return res;
    }


    public List<Integer> kthSmallestAbsoluteDifferenceOfTwoElementsInAnArray(int[] nums, int k) {
        Arrays.sort(nums);

        Queue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (int i = 0; i < nums.length - 1; i++) {
            Node cur = new Node(i, i + 1, nums[i + 1] - nums[i]);
            heap.offer(cur);
        }

        Node result = null;
        while (k > 0) {
            Node cur = heap.poll();
            result = cur;

            if (cur.right + 1 < nums.length) {
                heap.offer(new Node(cur.left, cur.right + 1, nums[cur.right + 1] - nums[cur.left]));
            }
            k--;
        }
        return result == null ? ImmutableList.of() : ImmutableList.of(nums[result.left], nums[result.right]);
    }

    class Node {
        int left;
        int right;
        int val;

        Node(int left, int right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
