package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import array.CombinationSum;

public class CombinationSumTest {
	@Test
	public void combinationSumTest() {
		CombinationSum test = new CombinationSum();
		int[] candidates = { 2, 2, 3, 6, 7 };
		List<List<Integer>> actual = test.combinationSum(candidates, 7);
		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(2);
		l1.add(2);
		l1.add(3);
		List<Integer> l2 = new ArrayList<>();
		l2.add(7);
		expected.add(l1);
		expected.add(l2);
		assertEquals(expected, actual);
	}
}
