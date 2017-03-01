package array;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.<p>
 * <br>
 * Created by Bohan Zheng on 9/9/2015.
 *
 * @author Bohan Zheng
 */
public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int[][] heights = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix[0].length; i++) {
      heights[0][i] = matrix[0][i] - '0';
    }
    for (int i = 1; i < heights.length; i++) {
      for (int j = 0; j < heights[i].length; j++) {
        heights[i][j] = matrix[i][j] == '0' ? 0 : 1 + heights[i - 1][j];
      }
    }
    //using the function from Largest Rectangle in histogram
    LargestRectangleinHistogram helper = new LargestRectangleinHistogram();
    int maxArea = 0;
    for (int[] height : heights) {
      maxArea = Math.max(maxArea, helper.largestRectangleArea(height));
    }
    return maxArea;
  }
}
