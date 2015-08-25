package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (<b>C</b>) and a target number (<b>T</b>), find all unique combinations in
 * <b>C</b> where the candidate numbers sums to <b>T</b>. <br>
 * Each number in <b>C</b> may only be used <b>once</b> in the combination. <br>
 * <b>Note</b>:
 * <ol>
 * <li>All numbers (including target) will be positive integers.</li>
 * <li>Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).</li>
 * <li>The solution set must not contain duplicate combinations.</li>
 * </ol>
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,<br>
 * A solution set is:<br>
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author Bohan Zheng
 *
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		dfsHelper(candidates, target, 0, 0, res, new ArrayList<Integer>());
		return res;
	}
	
	private void dfsHelper(int[] candidates, int target, int i, int sum, List<List<Integer>> res, List<Integer> tmp) {
		if (sum >= target) {
			return;
		}
		for (; i < candidates.length; i++) {
			tmp.add(candidates[i]);
			if (sum + candidates[i] == target) {
				res.add(new ArrayList<>(tmp));
			}
			dfsHelper(candidates, target, i + 1, sum + candidates[i], res, tmp);
			tmp.remove(tmp.size() - 1);
			while (i + 1 < candidates.length && candidates[i + 1] == candidates[i])
				i++;
		}
	}
}
