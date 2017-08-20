package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * <p>
 * Created by Bohan Zheng on 3/29/2016.
 *
 * @author Bohan Zheng
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreHelper(res, s, 0, new StringBuilder(), 0);
        return res;
    }

    private void restoreHelper(List<String> res, String s, int i, StringBuilder sb, int num) {
        if (num == 4) {
            if (i == s.length()) {
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
                sb.append('.');
            }
            return;
        }
        for (int n = 1; n <= 3 && i + n <= s.length(); ++n) {
            if (s.charAt(i) == '0' && n != 1) {
                continue;
            }
            String subs = s.substring(i, i + n);
            if (0 <= Integer.valueOf(subs) && Integer.valueOf(subs) <= 255) {
                sb.append(subs).append('.');
                restoreHelper(res, s, i + n, sb, num + 1);
                int x = sb.length();
                sb.delete(x - n - 1, x);
            }
        }
    }
}
