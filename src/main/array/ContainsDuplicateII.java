package main.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an main.array of integers and an integer k, find out whether there are two distinct indices i and j in the
 * main.array such that nums[i] = nums[j] and the difference between i and j is at most k.<br>
 * For reference, look here:<a href="https://leetcode.com/problems/contains-duplicate-ii/">leetcode</a>
 * 
 * @author Bohan Zheng
 *
 */
public class ContainsDuplicateII {
	public boolean solution1(int[] nums, int k) {
		Map<Integer, Integer> table = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (table.containsKey(nums[i]) && i - table.get(nums[i]) <= k) {
				return true;
			}
			table.put(nums[i], i);
		}
		return false;
	}
}
