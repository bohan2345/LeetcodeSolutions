package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters
 * and is fully (left and right) justified. You should pack your words in a greedy approach; that is,
 * pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line
 * has exactly L characters. Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left
 * will be assigned more spaces than the slots on the right.For the last line of text, it should be left
 * justified and no extra space is inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 * <p>
 * Created by Bohan Zheng on 3/14/2016.
 *
 * @author Bohan Zheng
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int totalLength = 0;
        List<String> tmpWords = new ArrayList<>();
        for (String word : words) {
            if (totalLength + tmpWords.size() + word.length() > maxWidth) {
                res.add(format(tmpWords, maxWidth, totalLength));
                totalLength = 0;
                tmpWords.clear();
            }
            totalLength += word.length();
            tmpWords.add(word);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(tmpWords.get(0));
        for (int i = 1; i < tmpWords.size(); i++) {
            sb.append(' ');
            sb.append(tmpWords.get(i));
        }
        appendSpaces(sb, maxWidth - sb.length());
        res.add(sb.toString());
        return res;
    }

    private String format(List<String> words, int maxWidth, int totalLength) {
        StringBuilder sb = new StringBuilder(maxWidth);
        sb.append(words.get(0));
        if (words.size() == 1) {
            appendSpaces(sb, maxWidth - totalLength);
            return sb.toString();
        }
        int spaces = maxWidth - totalLength;
        int n = words.size() - 1;
        for (int i = 1; i < words.size(); i++) {
            int numSpaces = (int) Math.ceil(spaces / (n * 1.0));
            appendSpaces(sb, numSpaces);
            spaces -= numSpaces;
            n--;
            sb.append(words.get(i));
        }
        return sb.toString();
    }

    private void appendSpaces(StringBuilder sb, int n) {
        while (n > 0) {
            sb.append(' ');
            n--;
        }
    }
}
