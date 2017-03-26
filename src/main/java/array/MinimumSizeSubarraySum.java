package array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum > s.
 * If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    int minLength = nums.length;
    int left = 0, right = 0, sum = 0;
    while (right <= nums.length) {
      if (right < nums.length && sum < s) {
        sum += nums[right];
        right++;
      } else if (sum >= s) {
        minLength = Math.min(minLength, right - left);
        sum -= nums[left];
        left++;
      } else {
        right++;
      }
    }
    return left == 0 && sum < s ? 0 : minLength;
  }
}
