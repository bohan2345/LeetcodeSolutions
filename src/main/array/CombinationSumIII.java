package main.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(k, n, res, new ArrayList<>());
        return res;
    }

    void dfsHelper(int k, int n, List<List<Integer>> res, List<Integer> tmpCombination) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(tmpCombination));
            return;
        }
        int i = tmpCombination.size() == 0 ? 1 : tmpCombination.get(tmpCombination.size() - 1) + 1;
        for (; i <= 9; i++) {
            tmpCombination.add(i);
            dfsHelper(k - 1, n - i, res, tmpCombination);
            tmpCombination.remove(tmpCombination.size() - 1);
        }
    }
}
