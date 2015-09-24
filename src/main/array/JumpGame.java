package main.array;

/**
 * Given an main.array of non-negative integers, you are initially positioned at the first index of the main.array. <br>
 * Each element in the main.array represents your maximum jump length at that position. <br>
 * Determine if you are able to reach the last index. <br>
 * <b>For example</b>:<br>
 * A = [2,3,1,1,4], return true. <br>
 * A = [3,2,1,0,4], return false.
 * 
 * @author Bohan Zheng
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int stepLeft = 1;
		int i = -1;
		while (i < nums.length - 1 && stepLeft > 0) {
			stepLeft--;
			i++;
			stepLeft = Math.max(stepLeft, nums[i]);
		}
		return i == nums.length - 1;
	}
}
