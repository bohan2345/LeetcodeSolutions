package google;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Created by Bohan Zheng on 7/6/16.
 *
 * @author Bohan Zheng
 */
public class FirstDuplicateNumber {
    public int firstDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int res = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                res = nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return res;
    }
}
