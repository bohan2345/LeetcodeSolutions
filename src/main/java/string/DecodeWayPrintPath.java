package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecodeWayPrintPath {
    public List<String> decodeWay(String s) {
        Map<Integer, List<String>> cache = new HashMap<>();
        return helper(s, 0, cache);
    }

    private List<String> helper(String s, int index, Map<Integer, List<String>> cache) {
        List<String> result = new ArrayList<>();
        if (index == s.length()) {
            result.add("");
            return result;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        if (s.charAt(index) != '0') {
            List<String> next = helper(s, index + 1, cache);
            for (String n : next) {
                result.add(s.charAt(index) + "," + n);
            }
        }

        if (index < s.length() - 1) {
            int tmp = Integer.valueOf(s.substring(index, index + 2));
            if (tmp >= 10 && tmp <= 26) {
                List<String> next = helper(s, index + 2, cache);
                for (String n : next) {
                    result.add(s.substring(index, index + 2) + "," + n);
                }
            }
        }
        cache.put(index, result);
        return result;
    }
}
