package main.array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.<p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).<p>
 * Find the minimum element.<p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Created by Bohan Zheng on 11/24/2015.
 *
 * @author Bohan Zheng
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isMin(nums, mid)) {
                return nums[mid];
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[0];
    }

    private boolean isMin(int[] nums, int i) {
        return (i > 0 && i < nums.length - 1 && nums[i] < nums[i + 1] && nums[i] < nums[i - 1]) ||
                (i == 0 && nums.length == 1) ||
                (i == 0 && nums[i] < nums[i + 1]) ||
                (i == nums.length - 1 && nums[i] < nums[i - 1]);
    }
}
