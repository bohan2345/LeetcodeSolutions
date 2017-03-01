package array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.<p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.<p>
 * <b>Note:</b>
 * You are not suppose to use the library's sort function for this problem.<p>
 * <b>Follow up:</b>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 * then 1's and followed by 2's.<br>
 * Could you come up with an one-pass algorithm using only constant space?<p>
 * <br>
 * Created by Bohan Zheng on 9/3/2015.
 *
 * @author Bohan Zheng
 */
public class SortColor {
  public void sortColors(int[] nums) {
    int zero = 0, one = 0, two = nums.length - 1;
    while (one <= two) {
      if (nums[one] == 0) {
        swap(nums, zero, one);
        zero++;
        one++;
      } else if (nums[one] == 2) {
        swap(nums, one, two);
        two--;
      } else {
        one++;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
