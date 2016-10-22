package array;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Created by Bohan Zheng on 11/24/2015.
 *
 * @author Bohan Zheng
 */
public class FindMinimuminRotatedSortedArrayII {
    /*
    if the array is in order don't have pivot. then left <= mid <= right;
    so if mid < left there must be a pivot on the left side
    if mid > right there must be a pivot on the right side
    for all other cases, we can't tell, so we can safely left++.
    because if left is the min value, then left < mid will be true.
    if left < right (left == right we can tell) then the array is in order, return nums[left]
    */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right && nums[right] <= nums[left]) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                left++;
            }
        }
        return nums[left];
    }
}
