package main.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.<p>
 * For example, given k = 3, Return [1,3,3,1].<p>
 * Note:<br>
 * Could you optimize your algorithm to use only O(k) extra space?
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> res= new ArrayList<>(rowIndex);
        res.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<>(i + 1);
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(res.get(j - 1) + res.get(j));
            }
            tmp.add(1);
            res = tmp;
        }
        return res;
    }
}
