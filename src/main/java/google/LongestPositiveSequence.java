package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, print out the longest sequence of positive integers.
 * For example, given {-1, 2, 3, -4, 6, 12, 8, 9, -3, -5}, print out {6, 12, 8, 9}
 * <p>
 * Created by Bohan Zheng on 7/2/16.
 *
 * @author Bohan Zheng
 */
public class LongestPositiveSequence {
    public List<Integer> findLongest(int[] nums) {
        int left = 0;
        int right = 0;
        int index = 0;
        int maxLength = 0;
        for (; right < nums.length; right++) {
            if (nums[right] > 0) {
                if (right - left > maxLength) {
                    maxLength = right - left;
                    index = left;
                }
            } else {
                left = right;
            }
        }
        List<Integer> res = new ArrayList<>(maxLength);
        for (int i = index + 1; i <= index + maxLength; i++) {
            res.add(nums[i]);
        }
        return res;
    }

}
