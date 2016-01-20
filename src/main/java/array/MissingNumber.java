package array;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.<p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:<br>
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length;) {
            if (nums[i] >= nums.length || nums[i] < 0 || nums[i] == nums[nums[i]]) {
                i++;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
