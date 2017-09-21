package array;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        Arrays.fill(f, 1);
        Arrays.fill(g, 1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    } else if (f[i] == f[j] + 1) {
                        g[i] += g[j];
                    }
                }
            }
            if (f[i] > maxLen) {
                maxLen = f[i];
                count = g[i];
            } else if (f[i] == maxLen) {
                count += g[i];
            }
        }
        return count;
    }
}
