package google.dp;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class HouseRobber {
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
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(nums[i] + lastlast, last);
            lastlast = last;
            last = cur;
        }
        return last;
    }
}
