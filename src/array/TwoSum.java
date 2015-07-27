package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] solution1(int[] nums, int target) {
		Map<Integer, Integer> table = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (table.containsKey(target - nums[i])) {
				return new int[] {table.get(target - nums[i]), i + 1};
			}
			table.put(nums[i], i + 1);
		}
		throw new RuntimeException("Nothing found!");
	}
}
