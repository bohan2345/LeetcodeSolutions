package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * all combinations of phone number representation, with restriction that the words can only be from a dictionary,
 * with possible digits at front/end, such as 800 TARGET 234.
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class CombinationsofPhoneNumber {
    public List<String> findAllCombinations(String phoneNumber, Set<String> dic) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < phoneNumber.length(); i++)
            dfsHelper(phoneNumber, i, new StringBuilder(), dic, res, keyMap());
        return res;
    }

    private void dfsHelper(String phoneNumber, int index, StringBuilder sb, Set<String> dic, List<String> res, List<List<Character>> keyMap) {
        if (dic.contains(sb.toString())) {
            String prefix = phoneNumber.substring(0, index - sb.length());
            String suffix = phoneNumber.substring(index);
            res.add(prefix + sb.toString() + suffix);
        }
        if (index >= phoneNumber.length()) {
            return;
        }
        int n = Character.getNumericValue(phoneNumber.charAt(index));
        List<Character> key = keyMap.get(n);
        for (Character aKey : key) {
            sb.append(aKey);
            dfsHelper(phoneNumber, index + 1, sb, dic, res, keyMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private List<List<Character>> keyMap() {
        List<List<Character>> keyMap = new ArrayList<>();
        List<Character> key0 = Arrays.asList(' ');
        List<Character> key1 = new ArrayList<>();
        List<Character> key2 = Arrays.asList('a', 'b', 'c');
        List<Character> key3 = Arrays.asList('d', 'e', 'f');
        List<Character> key4 = Arrays.asList('g', 'h', 'i');
        List<Character> key5 = Arrays.asList('j', 'k', 'l');
        List<Character> key6 = Arrays.asList('m', 'n', 'o');
        List<Character> key7 = Arrays.asList('p', 'q', 'r', 's');
        List<Character> key8 = Arrays.asList('t', 'u', 'v');
        List<Character> key9 = Arrays.asList('w', 'x', 'y', 'z');
        keyMap.add(key0);
        keyMap.add(key1);
        keyMap.add(key2);
        keyMap.add(key3);
        keyMap.add(key4);
        keyMap.add(key5);
        keyMap.add(key6);
        keyMap.add(key7);
        keyMap.add(key8);
        keyMap.add(key9);
        return keyMap;
    }

}
