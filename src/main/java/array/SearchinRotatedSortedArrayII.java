package array;

/**
 * Follow up for "Search in Rotated Sorted Array":<br>
 * What if duplicates are allowed?<br>
 * Would this affect the run-time complexity? How and why?<p>
 * <br>
 * Created by Bohan Zheng on 9/8/2015.
 *
 * @author Bohan Zheng
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[left]) {
                if (target <= nums[right] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}
