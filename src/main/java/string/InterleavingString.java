package string;

/**
 * Created by bohan on 8/31/2016.
 *
 * @author Bohan Zheng
 */
public class InterleavingString {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * f(i, j) denotes s3.substring(0, i + j) is formed by interleaving of s1.substring(0, i) and
     * s2.substring(0, j)
     * <p>
     * f(i, j) = f(i - 1, j),                if (s1[i] == s3[i + j])
     * = f(i, j - 1),                if (s2[j] == s3[i + j])
     * = f(i - 1, j) || f(i, j - 1), if (s1[i] == s3[i + j] && s2[j] == s3[i + j])
     *
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                break;
            }
            f[i][0] = true;
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) != s3.charAt(j - 1)) {
                break;
            }
            f[0][j] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j] || f[i][j - 1];
                } else if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    f[i][j] = f[i - 1][j];
                } else if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    f[i][j] = f[i][j - 1];
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
