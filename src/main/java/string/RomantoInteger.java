package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Created by Bohan Zheng on 2/20/16.
 *
 * @author Bohan Zheng
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int last = 0, num = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = map.get(s.charAt(i));
            if (n >= last) {
                num += n;
            } else {
                num -= n;
            }
            last = n;
        }
        return num;
    }
}
