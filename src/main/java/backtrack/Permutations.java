package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * Created by Bohan Zheng on 7/1/2016.
 *
 * @author Bohan Zheng
 */
public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    searchHelper(res, new ArrayList<>(), nums, new boolean[nums.length]);
    return res;
  }

  public void searchHelper(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used) {
    if (tmp.size() == nums.length) {
      res.add(new ArrayList<>(tmp));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      tmp.add(nums[i]);
      used[i] = true;
      searchHelper(res, tmp, nums, used);
      used[i] = false;
      tmp.remove(tmp.size() - 1);
    }
  }
}
