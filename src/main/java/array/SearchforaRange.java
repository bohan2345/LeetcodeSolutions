package array;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value. <br>
 * Your algorithm's runtime complexity must be in the order of O(log n). <br>
 * If the target is not found in the array, return [-1, -1]. <br>
 * For example,<br>
 * Given [5, 7, 7, 8, 8, 10] and target value 8,<br>
 * return [3, 4].
 *
 * @author Bohan Zheng
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int i = binarySearch(nums, target);
        if (i == -1) {
            return res;
        } else {
            int j = 1, k = 1;
            while (i - j >= 0 && nums[i - j] == nums[i]) {
                j++;
            }
            res[0] = i - j + 1;

            while (i + k < nums.length && nums[i + k] == nums[i]) {
                k++;
            }
            res[1] = i + k - 1;
        }
        return res;
    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
