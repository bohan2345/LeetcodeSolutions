package google;

/**
 * “3a2[mtv]ac”,  decompress to: aaamtvmtvac
 * <p>
 * Created by Bohan Zheng on 7/9/16.
 *
 * @author Bohan Zheng
 */
public class DecodeStringII {
    public String decode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                int j = getNumber(str, i);
                int n = Integer.valueOf(str.substring(i, j));
                i = j;
                if (str.charAt(j) == '[') {
                    int k = findPairParentese(str, j);
                    i = k;
                    String substr = str.substring(j + 1, k);
                    appendString(sb, n, substr);
                } else {
                    char c = str.charAt(j);
                    appendChar(sb, n, c);
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    private int getNumber(String str, int i) {
        for (int j = i; j < str.length(); j++) {
            if (!(str.charAt(j) <= '9' && str.charAt(j) >= '0')) {
                return j;
            }
        }
        return str.length();
    }

    private int findPairParentese(String str, int i) {
        int count = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                count++;
            } else if (str.charAt(i) == ']') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        return str.length();
    }

    private void appendChar(StringBuilder sb, int n, char c) {
        for (; n > 0; n--) {
            sb.append(c);
        }
    }

    private void appendString(StringBuilder sb, int n, String str) {
        String s = decode(str);
        for (; n > 0; n--)
            sb.append(s);
    }

    public String encode(String str) {
        if (str.length() < 2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            i = match(str, i, sb);
        }
        return sb.toString();
    }

    private int match(String str, int i, StringBuilder sb) {
        int count = 0;
        int[] table = KMPTable(str, i);

        int x = 0;
        for (int y = 0; y < table.length; y++) {
            if (table[y] > count) {
                count = table[y];
                x = y;
            }
        }
        int leng = x - count;
        if (count == 0 || count < leng) {
            sb.append(str.charAt(i));
            return i + 1;
        } else {
            int n = (count / leng) + 1;
            String sub = str.substring(i, i + leng);
            sub = encode(sub);
            sb.append(n);
            if (leng > 1) {
                sb.append('[').append(sub).append(']');
            } else {
                sb.append(sub);
            }
            return i + n * leng;
        }
    }


    public int[] KMPTable(String w, int offset) {
        int[] next = new int[w.length() + 1 - offset];
        next[0] = -1;
        if (w.length() == 1) {
            return next;
        }
        next[1] = 0;
        int i = 0, j = 1;
        while (j + offset < w.length()) {
            while (i >= 0 && w.charAt(i + offset) != w.charAt(j + offset)) {
                i = next[i];
            }
            i++;
            j++;
            next[j] = i;
        }
        return next;
    }
}
