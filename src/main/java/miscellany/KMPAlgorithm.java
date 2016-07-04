package miscellany;

/**
 * A string matching algorithm wants to find the starting index m in string S[] that matches the search word W[]
 * <p>
 * For Example:
 * S = ABC ABCDAB ABCDABCDABDE
 * W = ABCDABD
 * Return 15
 * <p>
 * Created by Bohan Zheng on 3/17/2016.
 *
 * @author Bohan Zheng
 */
public class KMPAlgorithm {
    public int findMatch(String s, String w) {
        int m = 0, i = 0;
        char[] S = s.toCharArray(), W = w.toCharArray();
        int[] T = KMPTable(W);
        while (m + i < s.length()) {
            if (W[i] == S[m + i]) {
                if (i == W.length - 1) {
                    return m;
                }
                i++;
            } else {
                if (T[i] > -1) {
                    m = m + i - T[i];
                    i = T[i];
                } else {
                    i = 0;
                    m++;
                }
            }
        }
        return S.length;
    }

    /**
     * Generate the Partial match table
     * http://www.rudy-yuan.net/archives/182/
     *
     * @param w
     *         word pattern
     * @return array with the same length of the pattern,
     * for each value v for a given index i means, the substring from i - v to i match the beginning of the string with length v.
     * if matching fails at index i, the next start search index should be m + i - v.
     * m denotes last start search index.
     */
    public int[] KMPTable(char[] w) {
        int[] next = new int[w.length];
        next[0] = -1;
        if (w.length == 1) {
            return next;
        }
        next[1] = 0;
//        int cnd = 0, pos = 2;
//        while (pos < w.length) {
//            if (w[pos - 1] == w[cnd]) {
//                next[pos] = cnd + 1;
//                cnd++;
//                pos++;
//            } else if (cnd > 0) {
//                cnd = next[cnd];
//            } else {
//                next[pos] = 0;
//                pos++;
//            }
//        }
        int i = 0, j = 1;
        while (j < w.length - 1) {
            while (i >= 0 && w[i] != w[j]) {
                i = next[i];
            }
            i++;
            j++;
            next[j] = i;
        }
        return next;
    }
}
