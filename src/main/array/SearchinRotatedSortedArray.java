package main.array;

/**
 * Suppose a sorted main.array is rotated at some pivot unknown to you beforehand. <br>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). <br>
 * You are given a target value to search. If found in the main.array return its index, otherwise return -1. <br>
 * You may assume no duplicate exists in the main.array.
 *
 * @author Bohan Zheng
 *
 */
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < nums[left]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
