package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak1dot5 {
    public String wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);

        HashMap<String, String> hashMap = new HashMap<>();
        return helper(s, dict, hashMap);
    }

    private String helper(String s, Set<String> dict, HashMap<String, String> map) {
        String result = null;
        if (s.length() == 0) {
            return "";
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);
            if (dict.contains(current)) {
                String next = s.substring(i);
                String oneCut = helper(next, dict, map);

                if (oneCut != null) {
                    result = current + " " + oneCut;
                    break;
                }
            }
        }

        map.put(s, result);
        return result;
    }
}
