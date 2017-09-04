package string;

public class DecodeWaysII {
    //    public int numDecodings(String s) {
//        long[] f = new long[s.length() + 1];
//        f[0] = 1;
//        char[] str = s.toCharArray();
//        for (int i = 1; i <= s.length(); i++) {
//            // Only use index `i` str[i] != 0,
//            if (str[i - 1] == '*') {
//                f[i] += f[i - 1] * 9;
//            } else {
//                f[i] += f[i - 1];
//            }
//            if (i == 1) {
//                continue;
//            }
//            // Use index `i` and `i - 1`;
//            if (str[i - 1] == '*' && str[i - 2] != '*') {
//                if (str[i - 2] == '1') {
//                    f[i] += f[i - 2] * 9;
//                } else if (str[i - 2] == '2') {
//                    f[i] += f[i - 2] * 6;
//                }
//            } else if (str[i - 1] != '*' && str[i - 2] == '*') {
//                if ('0' <= str[i - 1] && str[i - 1] <= '6') {
//                    f[i] += f[i - 2] * 2;
//                } else {
//                    f[i] += f[i - 2];
//                }
//            } else if (str[i - 1] == '*' && str[i - 2] == '*') {
//                f[i] += f[i - 2] * 15;
//            } else {
//                int n = Integer.valueOf(s.substring(i - 2, i));
//                if (10 <= n && n <= 26) {
//                    f[i] += f[i - 2];
//                }
//            }
//            f[i] %= 1000000007;
//        }
//        return (int) (f[s.length()] % 1000000007);
//    }
// }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        long[] f = new long[s.length() + 1];
        f[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if (c != '*') {
                if (c != '0') {
                    f[i] = f[i - 1] % 1000000007;
                }
                if (i < 2) {
                    continue;
                }
                char p = s.charAt(i - 2);
                if (p != '*') { // "12"
                    int lastTwo = Integer.valueOf(s.substring(i - 2, i));
                    if (lastTwo >= 10 && lastTwo <= 26) {
                        f[i] += f[i - 2] % 1000000007;
                    }
                } else { // "*2"
                    if (c >= '0' && c <= '6') { // 10-16 20-26
                        f[i] += (f[i - 2] * 2) % 1000000007;
                    } else if (c > '6') { // 17 18 19
                        f[i] += f[i - 2] % 1000000007;
                    }
                }
            } else {
                f[i] = (f[i - 1] * 9) % 1000000007;
                if (i < 2)
                    continue;
                char p = s.charAt(i - 2);
                if (p != '*') {
                    if (p == '1') {
                        f[i] += (f[i - 2] * 9) % 1000000007;
                    } else if (p == '2') {
                        f[i] += (f[i - 2] * 6) % 1000000007;
                    }
                } else {
                    f[i] += (f[i - 2] * 15) % 1000000007; // 21-26 11-19
                }
            }
        }
        return (int) (f[s.length()] % 1000000007);
    }
}
