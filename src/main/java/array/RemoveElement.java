package array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.<br>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.<br>
 * For reference, look here:<a href="https://leetcode.com/problems/remove-element/">leetcode</a>
 *
 * @author Bohan Zheng
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
