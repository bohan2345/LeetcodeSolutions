package array;

public class RemoveElement {
	public int solution1(int[] nums, int val) {
		int i = 0, j = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}
}
