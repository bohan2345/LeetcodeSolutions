package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>Elements in a subset must be in non-descending order.</li>
 * <li>The solution set must not contain duplicate subsets.</li>
 * </ul>
 * For example,<br>
 * If nums = [1,2,2], a solution is:
 * <p>
 * [<br>
 * [2],<br>
 * [1],<br>
 * [1,2,2],<br>
 * [2,2],<br>
 * [1,2],<br>
 * []<br>
 * ]
 * <p>
 * Created by Bohan Zheng on 10/7/2015.
 *
 * @author Bohan Zheng
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res, new ArrayList<>(), 0, nums);
        return res;
    }

    public void dfsHelper(List<List<Integer>> res, List<Integer> tmp, int i, int[] nums) {
        res.add(new ArrayList<>(tmp));
        if (i >= nums.length) {
            return;
        }
        for (; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfsHelper(res,tmp,i + 1, nums);
            int previous = tmp.remove(tmp.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == previous) {
                i++;
            }
        }
    }
}
