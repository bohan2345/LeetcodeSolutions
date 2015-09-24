package main.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an main.array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the main.array which gives the sum of target. <br>
 * <b>Note:</b>
 * <ul>
 * <li>Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)</li>
 * <li>The solution set must not contain duplicate quadruplets.</li>
 * </ul>
 * <b>For example,</b>given main.array S = {1 0 -1 0 -2 2}, and target = 0. <br>
 * A solution set is: (-1, 0, 0, 1), (-2, -1, 1, 2), (-2, 0, 0, 2)
 * 
 * @author Bohan Zheng
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		int i = 0;
		while (i < nums.length - 3) {
			int j = i + 1;
			List<List<Integer>> triplet = threeSum(nums, j, target - nums[i]);
			for (int x = 0; x < triplet.size(); x++) {
				List<Integer> quadlet = new ArrayList<>();
				quadlet.add(nums[i]);
				quadlet.add(triplet.get(x).get(0));
				quadlet.add(triplet.get(x).get(1));
				quadlet.add(triplet.get(x).get(2));

				res.add(quadlet);
			}
			i++;
			while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
				i++;
			}
		}
		return res;
	}

	public List<List<Integer>> threeSum(int[] nums, int i, int target) {
		List<List<Integer>> res = new ArrayList<>();
		while (i < nums.length - 2) {
			int j = i + 1;
			List<List<Integer>> doublet = twoSum(nums, j, target - nums[i]);
			for (int x = 0; x < doublet.size(); x++) {
				List<Integer> triplet = new ArrayList<>();
				triplet.add(nums[i]);
				triplet.add(doublet.get(x).get(0));
				triplet.add(doublet.get(x).get(1));

				res.add(triplet);
			}
			i++;
			while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
				i++;
			}
		}
		return res;
	}

	public List<List<Integer>> twoSum(int[] nums, int i, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int j = nums.length - 1;
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum > target) {
				j--;
				while (j > i && nums[j] == nums[j + 1]) {
					j--;
				}
			} else if (sum < target) {
				i++;
				while (i < j && nums[i] == nums[i - 1]) {
					i++;
				}
			} else {
				List<Integer> doublet = new ArrayList<>();
				doublet.add(nums[i]);
				doublet.add(nums[j]);
				res.add(doublet);
				i++;
				while (i < j && nums[i] == nums[i - 1]) {
					i++;
				}
			}
		}
		return res;
	}
}
