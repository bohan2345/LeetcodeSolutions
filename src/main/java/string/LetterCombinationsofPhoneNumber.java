package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Created by Bohan Zheng on 5/5/2016.
 *
 * @author Bohan Zheng
 */
public class LetterCombinationsofPhoneNumber {
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return res;
    }
    combinationHelper(res, new StringBuilder(), 0, digits, keyMap());
    return res;
  }

  private void combinationHelper(List<String> res, StringBuilder sb, int i, String digits, List<List<Character>> keyMap) {
    if (i == digits.length()) {
      res.add(sb.toString());
      return;
    }
    int x = Character.getNumericValue(digits.charAt(i));
    List<Character> chars = keyMap.get(x);
    for (char c : chars) {
      sb.append(c);
      combinationHelper(res, sb, i + 1, digits, keyMap);
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
