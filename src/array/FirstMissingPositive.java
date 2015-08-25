package array;

/**
 * Given an unsorted integer array, find the first missing positive integer.<br>
 * <b>For example</b>,<br>
 * Given [1,2,0] return 3,<br>
 * and [3,4,-1,1] return 2. <br>
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Bohan Zheng
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (!swapHelper(nums, i, nums[i] - 1) || nums[i] == i + 1) {
				i++;
			}
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	/**
	 * 
	 * @param nums
	 * @param i
	 *            - current index
	 * @param j
	 *            - target index, the position <b>i</b> will be swapped with.
	 * @return swap success or not
	 */
	private boolean swapHelper(int[] nums, int i, int j) {
		if (j >= nums.length || j < 0 || nums[i] == nums[j]) {
			return false;
		}
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
		return true;
	}
}
