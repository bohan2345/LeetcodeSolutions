package array;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <br>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
 * order). <br>
 * The replacement must be in-place, do not allocate extra memory. <br>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.<br>
 * 1,2,3 → 1,3,2<br>
 * 3,2,1 → 1,2,3<br>
 * 1,1,5 → 1,5,1
 * 
 * @author Bohan Zheng
 *
 */
public class NextPermutation {
	/**
	 * <ul>
	 * <li>From right to left, find the first number violated the increasing trend, call it PartitionNumber</li>
	 * <li>From right to left, find the first number greater than PartitionNumber, call it ChangeNumber</li>
	 * <li>Swap partitionNumber and changeNumber</li>
	 * <li>revert all number on the right side of the ChangeNumber(partitionNumber index)</li>
	 * </ul>
	 * 
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int i = findPartitionNumber(nums);
		if (i < 0) {
			Arrays.sort(nums);
			return;
		}
		int j = findChangeNumber(nums, i);
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
		revert(nums, i + 1);
	}

	int findPartitionNumber(int[] nums) {
		for (int i = nums.length - 2; i >= 0; --i) {
			if (nums[i] < nums[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	int findChangeNumber(int[] nums, int i) {
		for (int j = nums.length - 1; j > i; --j) {
			if (nums[j] > nums[i]) {
				return j;
			}
		}
		return -1;
	}

	void revert(int[] nums, int i) {
		int j = nums.length - 1;
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}
}
