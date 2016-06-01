package array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order. <br>
 * You may assume no duplicates in the array. <br>
 * Here are few examples.<br>
 * [1,3,5,6], 5 → 2 <br>
 * [1,3,5,6], 2 → 1 <br>
 * [1,3,5,6], 7 → 4 <br>
 * [1,3,5,6], 0 → 0
 *
 * @author Bohan Zheng
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (mid + 1 == nums.length || nums[mid + 1] > target) {
                    return mid + 1;
                }
                left = mid + 1;
            } else if (nums[mid] > target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return 0;
    }
}
