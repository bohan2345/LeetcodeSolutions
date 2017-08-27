package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.<br>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * <p>
 * Created by Bohan Zheng on 10/7/2015.
 *
 * @author Bohan Zheng
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int current = nums[0], next = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (next == nums[i]) {
                next++;
            } else {
                res.add(getRange(current, next - 1));
                current = nums[i];
                next = nums[i] + 1;
            }
        }
        res.add(getRange(current, next - 1));
        return res;
    }

    private String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
