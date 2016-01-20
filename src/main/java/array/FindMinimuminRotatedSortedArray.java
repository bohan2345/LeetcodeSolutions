package array;

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
        while (left < right && nums[left] >= nums[right]) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
