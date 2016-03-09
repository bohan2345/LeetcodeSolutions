package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {
	@Test
	public void solution1Test() {
		TwoSum ts = new TwoSum();
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] res = ts.solution1(nums, 4);
		assertArrayEquals(res, new int[] { 1, 3 });
	}
}
