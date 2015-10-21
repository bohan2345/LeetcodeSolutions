package main.array;

/**
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * Created by Bohan Zheng on 10/20/2015.
 *
 * @author Bohan Zheng
 */
public class RotateArray {
    /**
     * O(k) space solution
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arrays = new int[k];
        for (int i = 0; i < k; i++) {
            arrays[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arrays[i];
        }
    }

    /**
     * O(1) space solution
     * <ol>
     * <li>Divide the array two parts: 1,2,3,4 and 5,6,7</li>
     * <li>Rotate first part: 4,3,2,1,5,6,7</li>
     * <li>Rotate first part: 4,3,2,1,7,6,5</li>
     * <li>Rotate the whole array: 5,6,7,1,2,3,4</li>
     * </ol>
     *
     * @param nums
     * @param k
     */

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
