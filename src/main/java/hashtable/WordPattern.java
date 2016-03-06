package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * <p>
 * Created by Bohan Zheng on 3/6/16.
 *
 * @author Bohan Zheng
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, List<Integer>> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (patternMap.containsKey(c)) {
                patternMap.get(c).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                patternMap.put(c, indexList);
            }
        }
        boolean isSame = true;
        String lastWord = null;
        for (char c : patternMap.keySet()) {
            List<Integer> list = patternMap.get(c);
            isSame = lastWord == null || (!strs[list.get(0)].equals(lastWord) && isSame);
            lastWord = strs[list.get(0)];
            for (int i = 1; i < list.size(); i++) {
                isSame = isSame && strs[list.get(i - 1)].equals(strs[list.get(i)]);
            }
        }
        return isSame;
    }
}
