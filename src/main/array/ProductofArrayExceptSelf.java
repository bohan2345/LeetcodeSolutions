package main.array;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to
 * the product of all the elements of nums except nums[i].<p>
 * Solve it without division and in O(n).<p>
 * For example, given [1,2,3,4], return [24,12,8,6].<p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space
 * for the purpose of space complexity analysis.)
 * <p>
 * Created by Bohan Zheng on 10/22/2015.
 *
 * @author Bohan Zheng
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int leng = nums.length;
        int res[] = new int[leng];
        res[0] = 1;
        for (int i = 1; i < leng; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int product = 1;
        for (int i = leng - 2; i >= 0; i--) {
            product = nums[i + 1] * product;
            res[i] = res[i] * product;
        }
        return res;
    }
}
