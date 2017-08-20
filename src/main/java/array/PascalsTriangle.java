package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.<p>
 * For example, given numRows = 5,
 * Return<p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            throw new IllegalArgumentException();
        }
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows == 0) {
            return res;
        }
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = res.get(i - 1);
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < lastRow.size(); j++) {
                row.add(lastRow.get(j) + lastRow.get(j - 1));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
