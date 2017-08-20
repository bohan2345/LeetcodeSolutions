package miscellany;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 4/18/2016.
 *
 * @author Bohan Zheng
 */
public class LongestCommonSubstring {
    /**
     * s1.length() == n, s2.length() == m
     * 1. first calculate f(i, j) for each 0<=i<=n, 0<=j<=m pair.
     * f(i, j) denotes the length of common substring ending at index i in s1 and index j in s2 (exclusive)
     * in other words is the longest common suffix of s1.substring(0, i) and s2.substring(0, j)
     * 2. for each f(i, j) find the max value. Longest common substring is s1.substring(i - f(i, j), i)
     * 3. since there might be multiple substring with the same length, use a List to track all value
     */
    public List<String> commonSubstring(String s1, String s2) {
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    int leng = table[i][j] + 1;
                    table[i + 1][j + 1] = leng;
                    if (leng > maxLength) {
                        maxLength = leng;
                        res.clear();
                        res.add(s1.substring(i + 1 - leng, i + 1));
                    } else if (leng == maxLength) {
                        res.add(s1.substring(i + 1 - leng, i + 1));
                    }
                }
            }
        }
        return res;
    }

    /**
     * f(i, j) denotes the length of common substring ending at i in s1 and j in s2 (exclusive)
     * f(i, j) = f(i - 1, j - 1) + 1, if (s1[i] == s2[j])
     * = 0,                   if (s1[i] != s2[j])
     */
    public int commonSubstring2(String s1, String s2) {
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                table[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? table[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, table[i][j]);
            }
        }
        return max;
    }
}
