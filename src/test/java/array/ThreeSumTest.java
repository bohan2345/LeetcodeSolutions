package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {
	@Test
	public void threeSumTest() {
		ThreeSum ts = new ThreeSum();
		int[] nums = { 0, 0, 0 };
		List<List<Integer>> actual = ts.threeSum(nums);
		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(0);
		l.add(0);
		expected.add(l);
		assertEquals(expected, actual);
	}
}
