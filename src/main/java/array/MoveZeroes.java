package array;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.<p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].<p>
 * Note:<br>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
