package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums and a number n, nums is in ascending order.
 * add several elements to nums, so that the for each number in range [1, n]
 * can be get by the sum of a certain number of elements in array nums
 * return the minimum number of elements need to be added.
 * For example,
 * Given nums = [1,3] n = 6
 * Return 1 (need add number 2)
 * nums = [1,5,10] n = 20
 * Return 2 (need add number 2, 4)
 * <p>
 * Created by Bohan Zheng on 5/17/2016.
 *
 * @author Bohan Zheng
 */
public class ArrayPatch {
  /**
   * Greedy algrithm
   * if nums[0 -> k] can sum up to all integers from 0 to m
   * then if we add m + 1 to the nums, nums can sum up to all intergers from 0 to m + m + 1
   * this is the optimal option
   */
  public int numOfPatches(int[] nums, int n) {
    List<Integer> numList = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      sum += nums[i];
      while (sum < nums[i + 1]) {
        numList.add(sum + 1);
        sum += sum + 1;
      }
    }
    sum += nums[nums.length - 1];
    while (sum < n) {
      numList.add(sum + 1);
      sum += sum + 1;
    }
    return numList.size();
  }
}
