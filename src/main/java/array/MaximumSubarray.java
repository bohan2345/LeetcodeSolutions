package array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <br>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],<br>
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @author Bohan Zheng
 */
public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sum = 0, max = Integer.MIN_VALUE;
    for (int num : nums) {
      sum = Math.max(sum + num, num);
      max = Math.max(sum, max);
    }
    return max;
  }

  public int maxSubArray2(int[] nums) {
    return maxSubArray2Helper(nums, 0, nums.length - 1);
  }

  private int maxSubArray2Helper(int[] nums, int left, int right) {
    if (left >= right) {
      return nums[left];
    }
    int mid = left + (right - left) / 2;
    int a = Math.max(maxSubArray2Helper(nums, left, mid), maxSubArray2Helper(nums, mid + 1, right));
    int b = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = mid; i >= left; i--) {
      sum += nums[i];
      b = Math.max(sum, b);
    }
    sum = b;
    for (int i = mid + 1; i <= right; i++) {
      sum += nums[i];
      b = Math.max(sum, b);
    }
    return Math.max(a, b);
  }
}
