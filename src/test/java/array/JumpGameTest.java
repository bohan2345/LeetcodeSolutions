package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import array.JumpGame;

public class JumpGameTest {
	@Test
	public void testCanJump() {
		JumpGame test = new JumpGame();
		int[] A = { 2, 3, 1, 1, 4 };
		int[] B = { 3, 2, 1, 0, 4 };

		assertEquals(true, test.canJump(A));
		assertEquals(false, test.canJump(B));
	}
}
