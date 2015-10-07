package main.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle<br>
 * [<br>
 * [2],<br>
 * [3,4],<br>
 * [6,5,7],<br>
 * [4,1,8,3]<br>
 * ]<br>
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:<br>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * <br>
 * Created by Bohan Zheng on 10/6/2015.
 *
 * @author Bohan Zheng
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> minPathes = new ArrayList<>();
        minPathes.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            List<Integer> tmp = new ArrayList<>(level.size());
            for (int j = 1; j < level.size() - 1; j++) {
                int tmpMin = Math.min(minPathes.get(j - 1), minPathes.get(j));
                tmp.add(tmpMin + level.get(j));
            }
            tmp.add(0, level.get(0) + minPathes.get(0));
            tmp.add(level.get(level.size() - 1) + minPathes.get(minPathes.size() - 1));

            minPathes = tmp;
        }
        return Collections.min(minPathes);
    }
}
