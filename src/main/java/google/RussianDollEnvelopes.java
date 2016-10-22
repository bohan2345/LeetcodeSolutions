package google;

import java.util.Arrays;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope
 * is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * <p>
 * Created by Bohan Zheng on 7/5/2016.
 *
 * @author Bohan Zheng
 */
public class RussianDollEnvelopes {
    /**
     * 1. Sort the array. Ascend on width and descend on height if width are same.
     * 2. Find the longest increasing subsequence based on height.
     * Since the width is increasing, we only need to consider height.
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (en1, en2) -> {
            if (en1[0] == en2[0])
                return en2[1] - en1[1];
            else
                return en1[0] - en2[0];
        });
        int[] dp = new int[envelopes.length];
        int leng = 0;
        for (int[] en : envelopes) {
            int i = Arrays.binarySearch(dp, 0, leng, en[1]);
            if (i < 0) {
                i = i * -1 - 1;
            }
            dp[i] = en[1];
            if (i == leng) {
                leng++;
            }
        }
        return leng;
    }

    /**
     * basic DP
     */
    public int maxEnvelopesII(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int max = 0;
        int dp[] = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
