package google.dp;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n^2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class LongestIncreasingSubsequence {
  /**
   * f(i) denotes the longest subsequence end at nums[i]
   * f(i) = max(f(k) + 1), 0 < k < i, if nums[i] > nums[k]
   */
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] f = new int[nums.length];
    f[0] = 1;
    int res = 1;
    for (int i = 1; i < nums.length; i++) {
      int max = f[0];
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          max = Math.max(f[j] + 1, max);
        } else {
          max = Math.max(max, 1);
        }
      }
      f[i] = max;
      res = Math.max(f[i], res);
    }
    return res;
  }

  /**
   * dp[] is a increasing sequence,
   * for each number n in nums[],
   * find its insertion place i in dp[] from 0 to leng, dp[i] = n
   * dp[0] -> dp[i] is the longest increasion subsequence which end with element n
   * dp[0] -> dp[leng] will always be sorted.
   */
  public int lengthOfLISII(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    int len = 0;
    for (int x : nums) {
      int i = Arrays.binarySearch(dp, 0, len, x);
      if (i < 0) i = -(i + 1);
      dp[i] = x;
      if (i == len) len++;
    }
    return len;
  }
}
