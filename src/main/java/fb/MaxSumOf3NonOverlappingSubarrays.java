package fb;

import com.google.common.annotations.VisibleForTesting;

import java.util.Arrays;

public class MaxSumOf3NonOverlappingSubarrays {
    public int maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int[][] f = new int[sum.length][4];
        for (int[] ff : f) {
            Arrays.fill(ff, Integer.MIN_VALUE);
        }
        return maxSumOfRemainingSubarrays(sum, 3, k, 0, f);
    }

    private int maxSumOfRemainingSubarrays(int[] sum, int window, int k, int start, int[][] f) {
        if (window == 0) {
            return 0;
        }

        if (f[start][window] != Integer.MIN_VALUE) {
            return f[start][window];
        }

        int len = sum.length;
        int result = Integer.MIN_VALUE;
        for (int i = start; i <= len - 1 - window * k; i++) {
            int tmp = sum[i + k] - sum[i];
            result = Math.max(result, tmp + maxSumOfRemainingSubarrays(sum, window - 1, k, i + k, f));
        }
        f[start][window] = result;
        return result;
    }

    @VisibleForTesting
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
            //W is an array of sums of windows
            int[] W = new int[nums.length - K + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (i >= K) sum -= nums[i - K];
                if (i >= K - 1) W[i - K + 1] = sum;
            }

            int[] left = new int[W.length];
            int best = 0;
            for (int i = 0; i < W.length; i++) {
                if (W[i] > W[best]) best = i;
                left[i] = best;
            }

            int[] right = new int[W.length];
            best = W.length - 1;
            for (int i = W.length - 1; i >= 0; i--) {
                if (W[i] >= W[best]) best = i;
                right[i] = best;
            }

            int[] ans = new int[]{-1, -1, -1};
            for (int j = K; j < W.length - K; j++) {
                int i = left[j - K], k = right[j + K];
                if (ans[0] == -1 || W[i] + W[j] + W[k] >
                        W[ans[0]] + W[ans[1]] + W[ans[2]]) {

                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = k;
                }
            }
            return ans;
        }
    }

    @VisibleForTesting
    int getSum(int[] nums, int k) {
        int[] idx = new Solution().maxSumOfThreeSubarrays(nums, k);
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = idx[i]; j < idx[i] + k; j++) {
                sum += nums[j];
            }
        }
        return sum;
    }
}
