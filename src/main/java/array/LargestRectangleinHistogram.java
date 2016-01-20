package array;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.<p>
 * For example,<br>
 * Given height = [2,1,5,6,2,3], return 10.<p>
 * For reference, look here: <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">leetcode</a>
 * <p>
 * Created by Bohan Zheng on 9/9/2015.
 *
 * @author Bohan Zheng
 */
public class LargestRectangleinHistogram {
    /**
     * <ol>
     * <li>init empty stack</li>
     * <li>iterate from index 0 to n</li>
     * <li>if current position i, stack top element j, height[i] > height[j], push i<br>
     * if height[i] < height[j], pop j, compute max area = (i - j) * height[j]
     * </li>
     * </ol>
     * <b>reason:</b> area = width * height, every iteration, width++, if height[i] > height[j]<br>
     * means height of the rectangle not change and width++, so area is increasing.<p>
     * only when  height[i] < height[j], height is decreasing and width++, we don't konw what<br>
     * the new area will increase or not, so we compute the new max area in this case.<p>
     * And in this case the height of the rectangle is decreasing, so we pop the last highest height.<br>
     * (the height of the rectangle is determined by the lowest one)
     * @param height
     *         a list of height
     * @return the area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int h = i < height.length ? height[i] : 0;
            if (stack.empty() || height[stack.peek()] < h) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        return area;
    }
}
