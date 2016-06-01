package array;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
 * length.<br>
 * Do not allocate extra space for another array, you must do this in place with constant memory.<br>
 * For reference, look here:<a href="https://leetcode.com/problems/remove-element/">leetcode</a>
 *
 * @author Bohan Zheng
 */

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 1, j = 1;
        for (; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
