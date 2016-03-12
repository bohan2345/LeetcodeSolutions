package string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * Created by Bohan Zheng on 3/11/16.
 *
 * @author Bohan Zheng
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int x = 0;
        while (x < strs[0].length()) {
            for (int i = 1; i < strs.length; i++) {
                try {
                    if (strs[i - 1].charAt(x) != strs[i].charAt(x)) {
                        return strs[0].substring(0, x);
                    }
                } catch (Exception e) {
                    return strs[0].substring(0, x);
                }
            }
            x++;
        }
        return strs[0].substring(0, x);
    }
}
