package test;

import org.junit.Test;

import array.TrappingRainWater;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {
	@Test
	public void trapTest() {
		TrappingRainWater test = new TrappingRainWater();
		int[] height = {  };
		int actual = test.trap(height);
		assertEquals(0, actual);
	}
}
