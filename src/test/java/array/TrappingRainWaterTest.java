package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrappingRainWaterTest {
	@Test
	public void trapTest() {
		TrappingRainWater test = new TrappingRainWater();
		int[] height = {  };
		int actual = test.trap(height);
		assertEquals(0, actual);
	}
}
