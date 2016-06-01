package array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.<br>
 * <b>For example</b>, given array S = {-1 2 1 -4}, and target = 1.<br>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author Bohan Zheng
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new RuntimeException();
        }
        Arrays.sort(nums);
        int i = 0, j = 0, k = nums.length - 1;
        int closeSum = nums[0] + nums[1] + nums[2];
        while (i < nums.length - 2) {
            j = i + 1;
            k = nums.length - 1;
            int sum = nums[i] + twoSumClosest(nums, target - nums[i], j, k);
            closeSum = getCloseSum(sum, closeSum, target);
            i++;
        }
        return closeSum;
    }

    int twoSumClosest(int[] nums, int target, int j, int k) {
        int closeSum = nums[j] + nums[k];
        while (j < k) {
            int sum = nums[j] + nums[k];
            closeSum = getCloseSum(sum, closeSum, target);
            if (sum > target) {
                k--;
            } else {
                j++;
            }
        }
        return closeSum;
    }

    int getCloseSum(int sum, int closeSum, int target) {
        return Math.abs(sum - target) < Math.abs(closeSum - target) ? sum : closeSum;
    }
}
