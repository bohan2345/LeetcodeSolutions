package google;

import java.util.Arrays;

/**
 * <p>
 * Created by Bohan Zheng on 6/13/2016.
 *
 * @author Bohan Zheng
 */
public class TriangleCount {
  public int count(int[] nums) {
    if (nums == null || nums.length < 3) {
      throw new RuntimeException("Invalid input");
    }
    Arrays.sort(nums);
    int count = 0;
    for (int i = 2; i < nums.length; i++) {
      int left = 0, right = i - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum > nums[i]) {
          // need to add all pairs between left and right,
          // after right-- will lose this right position.
          count += right - left;
          right--;
        } else {
          left++;
        }
      }
    }
    return count;
  }
}
