package main.array;

/**
 * A peak element is an element that is greater than its neighbors.<p>
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.<p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.<p>
 * You may imagine that num[-1] = num[n] = -∞.<p>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * <p>
 * Created by Bohan Zheng on 11/24/2015.
 *
 * @author Bohan Zheng
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPeakElement(nums, mid)) {
                return mid;
            }
            if (isAscending(nums, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    private boolean isPeakElement(int[] nums, int i) {
        return (i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) ||
                (i == 0 && nums.length == 1) ||
                (i == 0 && nums[i] > nums[i + 1]) ||
                (i == nums.length - 1 && nums[i] > nums[i - 1]);
    }

    private boolean isAscending(int[] nums, int i) {
        return (i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i + 1] > nums[i]) ||
                (i == 0 && nums[i + 1] > nums[i]) ||
                (i == nums.length - 1 && nums[i] > nums[i - 1]);
    }
}
