package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. <br>
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based. <br>
 * You may assume that each input would have exactly one solution.<br>
 * For reference, look here:
 * <a href="https://leetcode.com/problems/two-sum/">leetcode</a>
 * 
 * @author Bohan Zheng
 *
 */
public class TwoSum {
	public int[] solution1(int[] nums, int target) {
		Map<Integer, Integer> table = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (table.containsKey(target - nums[i])) {
				return new int[] { table.get(target - nums[i]), i + 1 };
			}
			table.put(nums[i], i + 1);
		}
		throw new RuntimeException("Nothing found!");
	}
}