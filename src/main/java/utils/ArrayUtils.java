package utils;

/**
 * <p>
 * Created by Bohan Zheng on 6/15/2016.
 *
 * @author Bohan Zheng
 */
public class ArrayUtils {
    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
