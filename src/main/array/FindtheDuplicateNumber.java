package main.array;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.<p>
 * Note:<br>
 * You must not modify the array (assume the array is read only).<br>
 * You must use only constant, O(1) extra space.<br>
 * Your runtime complexity should be less than O(n^2).<br>
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * <p>
 * Created by Bohan Zheng on 11/19/2015.
 *
 * @author Bohan Zheng
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i = 1, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int largerNum = 0, smallerNum = 0;
            for (int n : nums) {
                if (n > mid && n <= j) {
                    largerNum++;
                } else if (n < mid && n >= i) {
                    smallerNum++;
                }
            }
            if (largerNum > j - mid) {
                i = mid + 1;
            } else if (smallerNum > mid - i) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}