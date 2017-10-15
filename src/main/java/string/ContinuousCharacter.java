package string;

import java.util.ArrayList;
import java.util.List;

public class ContinuousCharacter {
    public List<Character> continuousChar(String s) {
        List<Character> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int len = 1;
            int j = i + 1;
            while (j < s.length() && (s.charAt(i) == s.charAt(j) || s.charAt(j) == ' ')) {
                if (s.charAt(i) == s.charAt(j)) {
                    len++;
                }
                j++;
            }

            if (len == maxLen) {
                result.add(s.charAt(i));
            }

            if (len > maxLen) {
                maxLen = len;
                result.clear();
                result.add(s.charAt(i));
            }
            i = j - 1;
        }
        return result;
    }
}
