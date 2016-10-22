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
        int start = nums[0], end = nums[0];
        int count = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == nums[i]) {
                end++;
            } else {
                res.add(generateRangeStr(start, end));
                start = nums[i];
                end = nums[i];
                count = nums[i];
            }
            count++;
        }
        res.add(generateRangeStr(start, end));
        return res;
    }

    private String generateRangeStr(int start, int end) {
        return start == end ? Integer.toString(start) : Integer.toString(start) + "->" + Integer.toString(end);
    }
}
