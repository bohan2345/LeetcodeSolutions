package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/9/16.
 *
 * @author Bohan Zheng
 */
public class SplitArrayEqualSum {
  public int split(int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    int half = 0;
    for (int i = 0; i < nums.length; i++) {
      half += nums[i];
      sum -= nums[i];
      if (half == sum) {
        return i;
      }
    }
    throw new RuntimeException("no such index");
  }
}
