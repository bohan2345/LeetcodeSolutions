package main.array;

/**
 * Given an main.array of non-negative integers, you are initially positioned at the first index of the main.array. <br>
 * Each element in the main.array represents your maximum jump length at that position. <br>
 * Your goal is to reach the last index in the minimum number of jumps. <br>
 * <b>For example</b>:<br>
 * Given main.array A = [2,3,1,1,4] <br>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.)
 * 
 * @author Bohan Zheng
 *
 */
public class JumpGameII {
	public int jump(int[] nums) {
		int numOfJumps = 0;
		int i = 0;
		int maxLength = nums[i];
		while (i < nums.length - 1 && i < maxLength) {
			numOfJumps++;
			int newMaxLength = maxLength;
			for (; i < nums.length && i <= maxLength; i++) {
				newMaxLength = Math.max(newMaxLength, i + nums[i]);
			}
			i = maxLength;
			maxLength = newMaxLength;
		}
		return i >= nums.length - 1 ? numOfJumps : -1;
	}
}
