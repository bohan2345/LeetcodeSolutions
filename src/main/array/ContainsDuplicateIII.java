package main.array;

import java.util.TreeSet;

/**
 * Given an main.array of integers, find out whether there are two distinct indices i and j in the main.array such that the
 * difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.<br>
 * For reference, look here: <a href="https://leetcode.com/problems/contains-duplicate-iii/">leetcode</a>
 *
 * @author Bohan Zheng
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || k < 1 || t < 0) {
            return false;
        }
        TreeSet<Integer> S = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer ceiling = S.ceiling(nums[i]);
            Integer floor = S.floor(nums[i]);

            if ((ceiling != null && ceiling - num <= t) || (floor != null && num - t <= floor)) {
                return true;
            }
            S.add(num);
            if (i >= k) {
                S.remove(nums[i - k]);
            }
        }
        return false;
    }
}
