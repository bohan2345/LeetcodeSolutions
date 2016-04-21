package string;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p>
 * Note: The sequence of integers will be represented as a string.
 * <p>
 * Created by Bohan Zheng on 4/21/2016.
 *
 * @author Bohan Zheng
 */
public class CountandSay {
    public String countAndSay(int n) {
        return countAndSayHelper("1", n);
    }

    private String countAndSayHelper(String str, int n) {
        if (n == 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i + 1) == c){
                count++;
                i++;
            }
            sb.append(count).append(c);
        }
        return countAndSayHelper(sb.toString(), n - 1);
    }
}
