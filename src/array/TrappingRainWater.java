package array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining. <br>
 * <b>For example</b>,<br>
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6
 * <br>
 * For reference, look here: <a href="https://leetcode.com/problems/trapping-rain-water/">leetcode</a>
 * @author Bohan Zheng
 *
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int[] leftHighest = new int[height.length];
		int maxHight = 0;
		for (int i = 1; i < height.length; i++) {
			leftHighest[i] = Math.max(maxHight, height[i - 1]);
			maxHight = leftHighest[i];
		}
		maxHight = 0;
		int sum = 0;
		for (int j = height.length - 2; j >= 0; j--) {
			int rightHighest = Math.max(height[j + 1], maxHight);
			maxHight = rightHighest;
			int delta = Math.max(0, Math.min(rightHighest, leftHighest[j]) - height[j]);
			sum += delta;
		}
		return sum;
	}
}
