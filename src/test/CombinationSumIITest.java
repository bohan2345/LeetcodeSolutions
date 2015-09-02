package test;

import array.CombinationSumII;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CombinationSumIITest {
	@Test
	public void combinationSum2Test() {
		CombinationSumII test = new CombinationSumII();
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> actual = test.combinationSum2(candidates, 8);
		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		List<Integer> l4 = new ArrayList<>();
		l1.add(1);
		l1.add(7);
		l2.add(1);
		l2.add(2);
		l2.add(5);
		l3.add(2);
		l3.add(6);
		l4.add(1);
		l4.add(1);
		l4.add(6);
		expected.add(l1);
		expected.add(l2);
		expected.add(l3);
		expected.add(l4);
		assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}
}
