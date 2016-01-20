package array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. <br>
 * Each element in the array represents your maximum jump length at that position. <br>
 * Your goal is to reach the last index in the minimum number of jumps. <br>
 * <b>For example</b>:<br>
 * Given array A = [2,3,1,1,4] <br>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.)
 *
 * @author Bohan Zheng
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int steps = 0, max = nums[0];
        for (int i = 1; i < nums.length && max >= i; steps++) {
            for (int tmpMax = max; i < nums.length && i <= tmpMax; i++) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return max >= nums.length - 1 ? steps : -1;
    }
}