package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
 * numbers sums to T. <br>
 * The <b>same</b> repeated number may be chosen from C unlimited number of times. <br>
 * <b>Note:</b>
 * <ul>
 * <li>All numbers (including target) will be positive integers.</li>
 * <li>Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).</li>
 * <li>The solution set must not contain duplicate combinations.</li>
 * </ul>
 * <br>
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3]
 *
 * @author Bohan Zheng
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    dfsHelper(candidates, target, 0, res, new ArrayList<Integer>(), 0);
    return res;
  }

  private void dfsHelper(int[] candidates, int target, int i, List<List<Integer>> res, List<Integer> tmp, int sum) {
    if (sum >= target) {
      return;
    }
    for (; i < candidates.length; i++) {
      tmp.add(candidates[i]);
      if (sum + candidates[i] == target) {
        res.add(new ArrayList<>(tmp));
      }
      dfsHelper(candidates, target, i, res, tmp, sum + candidates[i]);
      tmp.remove(tmp.size() - 1);
      while (i + 1 < candidates.length && candidates[i + 1] == candidates[i])
        i++;
    }
  }
}
