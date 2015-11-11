package main.array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.<p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * <p>
 * Created by Bohan Zheng on 11/9/2015.
 *
 * @author Bohan Zheng
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int min = 1, max = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n < 0) {
                maxProduct = Math.max(min * n, maxProduct);
                int tmp = max;
                max = min * n;
                min = tmp * n;
            } else if (n > 0) {
                maxProduct = Math.max(max * n, maxProduct);
                max = max * n;
                min = min * n;
            } else {
                maxProduct = Math.max(0, maxProduct);
                max = 1;
                min = 1;
            }
            max = max > 0 ? max : 1;
            min = min < 0 ? min : 1;
        }
        return maxProduct;
    }
}
