package google;

/**
 * There are n balloons, each one has a point, for balloons i its points is nums[i]
 * if you blow balloon i up, you can get points nums[i - 1] * nums[i] * nums[i + 1];
 * after balloon i blow up, balloon i - 1 and i + 1 become adjacent.
 * Find the maximum points after blow up all balloons
 * Example
 * input: nums = [3, 1, 5, 8]
 * return: 167
 * <p>
 * Created by Bohan Zheng on 5/16/2016.
 *
 * @author Bohan Zheng
 */
public class Balloons {
  public int maxPoints(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n + 2][n + 2];
    boolean[][] visited = new boolean[n + 2][n + 2];
    int[] arr = new int[n + 2];
    System.arraycopy(nums, 0, arr, 1, n);
    arr[0] = 1;
    arr[n + 1] = 1;
    return search(arr, dp, visited, 1, n);
  }

  private int search(int[] arr, int[][] dp, boolean[][] visited, int left, int right) {
    if (visited[left][right]) {
      return dp[left][right];
    }
    int res = 0;
    for (int k = left; k <= right; k++) {
            /*
             * this value is get when all balloons is blust on both side of k,
             * in other words, balloon k is the last balloon in range left -> right
             * so the left adjcent balloon is left - 1 and right adjcent balloon is right + 1
             */
      int midVal = arr[left - 1] * arr[k] * arr[right + 1];
      int leftValue = search(arr, dp, visited, left, k - 1);
      int rightValue = search(arr, dp, visited, k + 1, right);
      res = Math.max(res, midVal + leftValue + rightValue);
    }
    visited[left][right] = true;
    dp[left][right] = res;
    return res;
  }
}
