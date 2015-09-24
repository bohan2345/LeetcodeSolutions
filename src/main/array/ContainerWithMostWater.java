package main.array;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water. <br>
 * Note: You may not slant the container.
 * <p>
 * For reference, look here: <a href="https://leetcode.com/problems/contains-duplicate/">leetcode</a>
 *
 * @author Bohan Zheng
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0, right = height.length - 1;
        int h = 0, w = 0;

        while (left < right) {
            w = right - left;
            if (height[left] < height[right]) {
                h = height[left];
                left++;
            } else {
                h = height[right];
                right--;
            }
            area = Math.max(area, h * w);
        }
        return area;
    }
}
