package google;

/**
 * 输入 a[4]bcd[3]efg, 要返回 aaaabcdddefg.
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class DecodeString {
    public String decode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                int length = getNumber(str, i);
                for (; length > 1; length--)
                    sb.append(str.charAt(i - 1));
                for (; i < str.length(); i++) {
                    if (str.charAt(i) == ']') break;
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    private int getNumber(String str, int i) {
        for (int j = i;j < str.length();j++) {
            if (str.charAt(j) == ']') {
                return Integer.valueOf(str.substring(i + 1, j));
            }
        }
        return 1;
    }

    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                int count = 2;
                for (; i < str.length() - 1; i++) {
                    if (str.charAt(i) == str.charAt(i + 1)) {
                        count++;
                    } else {
                        break;
                    }
                }
                sb.append('[').append(count).append(']');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
