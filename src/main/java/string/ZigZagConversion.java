package string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * <p>
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * Created by Bohan Zheng on 3/1/2016.
 *
 * @author Bohan Zheng
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        int size = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                res.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {//except the first row and the last row
                    int temp = j + size - 2 * i;
                    if (temp < s.length())
                        res.append(s.charAt(temp));
                }
            }
        }
        return res.toString();
    }
}
