package google;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] next = new int[nums.length];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // Store index.
        for (int i = 0; i < nums.length * 2; i++) {
            int n = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < n) {
                next[stack.pop()] = n;
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return next;
    }
}
