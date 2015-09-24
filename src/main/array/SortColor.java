package main.array;

/**
 * Given an main.array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.<p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.<p>
 * <b>Note:</b>
 * You are not suppose to use the library's sort function for this problem.<p>
 * <b>Follow up:</b>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the main.array counting number of 0's, 1's, and 2's, then overwrite main.array with total number of 0's,
 * then 1's and followed by 2's.<br>
 * Could you come up with an one-pass algorithm using only constant space?<p>
 * <br>
 * Created by Bohan Zheng on 9/3/2015.
 *
 * @author Bohan Zheng
 */
public class SortColor {
    public void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                if (!swap(nums, left, i)) {
                    i++;
                }
                left = nextNoZero(nums, left);
            } else if (nums[i] == 2) {
                if (!swap(nums, i, right)) {
                    i++;
                }
                right = nextNoTwo(nums, right);
            } else {
                i++;
            }
        }
    }

    public void sortColors(int[] A) {
        int zero = 0, one = 0, two = A.length - 1;
        while (one <= two) {
            if (A[one] == 0) {
                swap(A, zero, one);
                zero++;
                one++;
            } else if (A[one] == 2) {
                swap(A, one, two);
                two--;
            } else {
                one++;
            }
        }
    }

    private int nextNoZero(int[] nums, int i) {
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        return i;
    }

    private int nextNoTwo(int[] nums, int i) {
        while (i >= 0 && nums[i] == 2) {
            i--;
        }
        return i;
    }

    private boolean swap(int[] nums, int a, int b) {
        if (a >= b)
            return false;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
        return true;
    }
}
