package google.dp;

/**
 * <p>
 * Created by Bohan Zheng on 6/25/16.
 *
 * @author Bohan Zheng
 */
public class MaximumSubarrayIII {
    /**
     * f(i, j) denotes max sum for the first i numbers with j subarrays, where the ith element is in the last subarray.
     * f(i, j) = MAX(f(i - 1, j) + nums[i],                  // ith number and (i - 1)th number all in the last subarray.
     * f(i - k, j - 1) + nums[i]), 1 <= k <= i - j + 1    // ith number is a new subarray.
     *
     * @param nums: A list of integers
     * @param k:    An integer denote to find k non-overlapping subarrays
     * @return An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int[][] f = new int[nums.length + 1][k + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 1; j <= k; j++) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                f[i][j] = f[i - 1][j];
                for (int l = 1; l <= i - j + 1; l++) {
                    f[i][j] = Math.max(f[i][j], f[i - l][j - 1]);
                }
                f[i][j] += nums[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = k; i <= nums.length; i++) {
            max = Math.max(max, f[i][k]);
        }
        return max;
    }


}
