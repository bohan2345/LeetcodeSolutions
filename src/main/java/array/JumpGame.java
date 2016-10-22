package array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. <br>
 * Each element in the array represents your maximum jump length at that position. <br>
 * Determine if you are able to reach the last index. <br>
 * <b>For example</b>:<br>
 * A = [2,3,1,1,4], return true. <br>
 * A = [3,2,1,0,4], return false.
 *
 * @author Bohan Zheng
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int steps = 0;
        for (int i = 0; i < nums.length && steps >= i; i++) {
            steps = Math.max(steps, nums[i] + i);
        }
        return steps >= nums.length - 1;
    }
}