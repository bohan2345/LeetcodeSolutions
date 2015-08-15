package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero. <br>
 * Note:
 * <ul>
 * <li>Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) </il>
 * <li>The solution set must not contain duplicate triplets.</li>
 * </ul>
 * For reference, look here: <a href="https://leetcode.com/problems/3sum/">leetcode</a>
 * 
 * @author Bohan Zheng
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		int i = 0, j = 0, k = nums.length - 1;
		while (i < nums.length - 2) {
			j = i + 1;
			k = nums.length - 1;

			for (List<Integer> doublet : twoSum(nums, j, k, 0 - nums[i])) {
				List<Integer> triplet = new ArrayList<>();
				triplet.add(nums[i]);
				triplet.add(nums[doublet.get(0)]);
				triplet.add(nums[doublet.get(1)]);
				res.add(triplet);
			}

			i++;
			while (i < nums.length - 2 && nums[i - 1] == nums[i]) {
				i++;
			}
		}
		return res;
	}

	List<List<Integer>> twoSum(int[] nums, int j, int k, int target) {
		List<List<Integer>> res = new ArrayList<>();
		while (j < k) {
			if (nums[j] + nums[k] < target) {
				j++;
				while (j < k && nums[j - 1] == nums[j]) {
					j++;
				}
			} else if (nums[j] + nums[k] > target) {
				k--;
				while (k > j && nums[k] == nums[k + 1]) {
					k--;
				}
			} else {
				List<Integer> doublet = new ArrayList<>();
				doublet.add(j);
				doublet.add(k);
				res.add(doublet);
				j++;
				while (j < k && nums[j - 1] == nums[j]) {
					j++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 0, 0, 0 };
		System.out.println(new ThreeSum().threeSum(A).toString());
	}
}
