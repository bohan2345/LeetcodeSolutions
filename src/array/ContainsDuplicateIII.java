package array;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.<br>
 * For reference, look here: <a href="https://leetcode.com/problems/contains-duplicate-iii/">leetcode</a>
 * 
 * @author Bohan Zheng
 *
 */
public class ContainsDuplicateIII {
	public boolean solution1(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			if (checkDifferenceWithinKRange(nums, k, t, i)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDifferenceWithinKRange(int[] nums, int k, int t, int i) {
		for (int j = Math.max(0, i - k); j < nums.length; j++) {
			if (j == i) {
				continue;
			}
			if (Math.abs(nums[i] - nums[j]) <= t) {
				return true;
			}
		}
		return false;
	}
}
