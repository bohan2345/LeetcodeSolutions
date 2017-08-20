package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * follow up: duplicate are allowed
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * Created by Bohan Zheng on 7/1/2016.
 *
 * @author Bohan Zheng
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        searchHelper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void searchHelper(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        Set<Integer> tested = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || tested.contains(nums[i])) continue;
            tmp.add(nums[i]);
            tested.add(nums[i]);
            used[i] = true;
            searchHelper(res, tmp, nums, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
