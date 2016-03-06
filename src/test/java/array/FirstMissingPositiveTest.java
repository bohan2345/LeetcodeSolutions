package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstMissingPositiveTest {
	@Test
	public void firstMissingPositiveTest() {
		FirstMissingPositive test = new FirstMissingPositive();
		int actual1 = test
				.firstMissingPositive(new int[] { 11, 1, 6, 11, 5, 5, -6, 9, -3, 9, 5, 4, 2, -8, 16, -6, -4, 2, 3 });
		assertEquals(7, actual1);
		int actual2 = test.firstMissingPositive(new int[] { 3, 4, -1, 1 });
		assertEquals(2, actual2);
	}
}
