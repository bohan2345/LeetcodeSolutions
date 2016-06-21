package google;

import utils.ArrayUtils;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * <p>
 * Created by Bohan Zheng on 6/9/2016.
 *
 * @author Bohan Zheng
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int[] tem = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tem[i] = nums[i];
        }
        int mid = findMedium(tem);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = mid;
        }
        int l, r;
        if (nums.length % 2 == 0) {
            l = nums.length - 2;
            r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            l = 0;
            r = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l += 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r -= 2;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

    public int findMedium(int[] nums) {
        return findTopK(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }

    public int findTopK(int[] nums, int left, int right, int k) {
        int storeValue = nums[right];
        int pivotIndex = left;
        for (int i = left; i < nums.length - 1; i++) {
            if (nums[i] < storeValue) {
                ArrayUtils.swap(nums, i, pivotIndex);
                pivotIndex++;
            }
         }
        ArrayUtils.swap(nums, right, pivotIndex);
        if (pivotIndex - left == k - 1) {
            return storeValue;
        } else if (pivotIndex - left > k - 1) {
            return findTopK(nums, left, pivotIndex - 1, k);
        } else {
            return findTopK(nums, pivotIndex + 1, right, k - (pivotIndex - left) - 1);
        }
    }
}
