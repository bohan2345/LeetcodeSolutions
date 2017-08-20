package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrappingRainWaterTest {
    @Test
    public void trapTest() {
        TrappingRainWater test = new TrappingRainWater();
        int[] height = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
        int actual = test.trapII(height);
        assertEquals(83, actual);
    }

    @Test
    public void trapTest2() {
        TrappingRainWater test = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int actual = test.trapII(height);
        assertEquals(6, actual);
    }
}
