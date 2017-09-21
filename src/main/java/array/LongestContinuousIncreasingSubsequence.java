package array;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                f[i] = f[i - 1] + 1;
                maxLen = Math.max(maxLen, f[i]);
            }
        }
        return maxLen;
    }
}
