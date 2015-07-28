package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.<br>
 * For reference, look here:
 * <a href="https://leetcode.com/problems/contains-duplicate/">leetcode</a>
 * 
 * @author Bohan Zheng
 *
 */
public class ContainsDuplicateI {
	public boolean solution1(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (set.contains(i))
				return true;
			set.add(i);
		}
		return false;
	}
}