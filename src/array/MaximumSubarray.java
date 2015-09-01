package array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <br>
 * For example, given the array [?2,1,?3,4,?1,2,1,?5,4],<br>
 * the contiguous subarray [4,?1,2,1] has the largest sum = 6.
 *
 * @author Bohan Zheng
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(sum, max);
        }
        return max;
    }
}
