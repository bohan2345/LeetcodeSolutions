package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 1 For the return value, each inner list's elements must follow the lexicographic order.
 * 2 All inputs will be in lower-case.
 * Created by Bohan Zheng on 5/2/2016.
 *
 * @author Bohan Zheng
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                map.put(key, tmp);
            }
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
            res.add(map.get(key));
        }
        return res;
    }
}
