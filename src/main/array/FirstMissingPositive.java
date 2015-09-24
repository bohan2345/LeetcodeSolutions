package main.array;

/**
 * Given an unsorted integer main.array, find the first missing positive integer.<br>
 * <b>For example</b>,<br>
 * Given [1,2,0] return 3,<br>
 * and [3,4,-1,1] return 2. <br>
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * @author Bohan Zheng
 */
public class FirstMissingPositive {
    /**
     * <ol>
     * <li>we have n elements, iterate from 0 to n - 1</li>
     * <li>try to put every element e in the position i where i = e - 1</li>
     * <li>then iterate from 0 to n - 1, the first i where i + 1 != nums[i] is the first missing positive integer</li>
     * </ol>
     * <b>note: </b>
     * <ul>
     * <li>if element e - 1 >= n or e - 1 < 0, we can't find the position for it.</li>
     * <li>if element e already in its position, don't swap.</li>
     * </ul>
     *
     * @param nums
     *         main.array of positive integer
     * @return the first missing positive integer
     */
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (!swapHelper(nums, i, nums[i] - 1) || nums[i] == i + 1) {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * @param nums
     *         main.array of positive integer
     * @param i
     *         current index
     * @param j
     *         target index, the position <b>i</b> will be swapped with.
     * @return swap success or not
     */
    private boolean swapHelper(int[] nums, int i, int j) {
        if (j >= nums.length || j < 0 || nums[i] == nums[j]) {
            return false;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return true;
    }
}
