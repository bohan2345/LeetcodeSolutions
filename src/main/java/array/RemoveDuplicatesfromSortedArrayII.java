package array;

/**
 * Follow up for "Remove Duplicates":<br>
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.<p>
 * <br>
 * Created by Bohan Zheng on 9/4/2015.
 *
 * @author Bohan Zheng
 */
public class RemoveDuplicatesfromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int i = 1, count = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] == nums[j - 1]) {
        count++;
        if (count < 2) {
          nums[i] = nums[j];
          i++;
        }
      } else {
        nums[i] = nums[j];
        i++;
        count = 0;
      }
    }
    return i;
  }
}
