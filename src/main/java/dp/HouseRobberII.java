package dp;

/**
 * After robbing those houses on that street, the thief has found himself a new place
 * for his thievery so that he will not get too much attention. This time, all houses
 * at this place are arranged in a circle. That means the first house is the neighbor
 * of the last one. Meanwhile, the security system for these houses remain the same as
 * for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class HouseRobberII {
    /**
     * @param nums:
     *         An array of non-negative integers.
     *         return: The maximum amount of money you can rob tonight
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lastlast = nums[0];
        if (nums.length == 1) {
            return lastlast;
        }
        int last = Math.max(lastlast, nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int cur = Math.max(nums[i] + lastlast, last);
            lastlast = last;
            last = cur;
        }
        int max = last;
        lastlast = nums[nums.length - 1];
        last = Math.max(lastlast, nums[nums.length - 2]);
        for (int i = nums.length - 3; i > 0; i--) {
            int cur = Math.max(nums[i] + lastlast, last);
            lastlast = last;
            last = cur;
        }
        return Math.max(max, last);
    }
}
