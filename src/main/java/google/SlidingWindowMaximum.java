package google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very
 * left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * return the max sliding window as [3,3,5,5,6,7].
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Created by Bohan Zheng on 6/10/2016.
 *
 * @author Bohan Zheng
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0;
        int max = nums[0];
        for (; right < k; right++) {
            addtoDeque(deque, nums, right);
            max = nums[deque.peekLast()];
        }
        res[0] = max;
        for (; right < nums.length; right++, left++) {
            if (deque.peekLast() == left) {
                deque.pollLast();
            }
            addtoDeque(deque, nums, right);
            res[left + 1] = nums[deque.peekLast()];
        }
        return res;
    }

    private void addtoDeque(Deque<Integer> deque, int[] nums, int i) {
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekFirst()]) {
            deque.pollFirst();
        }
        deque.addFirst(i);
    }
}
