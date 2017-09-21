package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.<p>
 * <b>Note:</b>
 * <ul>
 * <li>Elements in a subset must be in non-descending order.</li>
 * <li>The solution set must not contain duplicate subsets.</li>
 * </ul>
 * For example,<br>
 * If nums = [1,2,3], a solution is:<p>
 * [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]<p>
 * <br>
 * Created by Bohan Zheng on 9/3/2015.
 *
 * @author Bohan Zheng
 */
public class Subsets {
//    public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        dfsHelper(nums, 0, new ArrayList<>(), res);
//        return res;
//    }
//
//    private void dfsHelper(int[] nums, int i, List<Integer> tmp, List<List<Integer>> res) {
//        res.add(new ArrayList<>(tmp));
//        if (tmp.size() == nums.length) {
//            return;
//        }
//        for (; i < nums.length; i++) {
//            tmp.add(nums[i]);
//            dfsHelper(nums, i + 1, tmp, res);
//            tmp.remove(tmp.size() - 1);
//        }
//    }

    public List<List<Integer>> subsets(int[] array) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(array, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] array, int i, List<List<Integer>> res, List<Integer> tmp) {
        if (i == array.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        dfs(array, i + 1, res, tmp);
        tmp.add(array[i]);
        dfs(array, i + 1, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
