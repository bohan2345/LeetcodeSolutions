package main.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 * <p>
 * Created by Bohan Zheng on 11/10/2015.
 *
 * @author Bohan Zheng
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null, candidate2 = null;
        int counter1 = 0, counter2 = 0;
        for (int n : nums) {
            if (candidate1 == null || counter1 == 0) {
                candidate1 = n;
                counter1 = 1;
            } else if (candidate1 == n) {
                counter1++;
            } else if (candidate2 == null || counter2 == 0) {
                candidate2 = n;
                counter2 = 1;
            } else if (candidate2 == n) {
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for (int n : nums) {
            if (n == candidate1)
                counter1++;
            else if (n == candidate2)
                counter2++;
        }
        List<Integer> res = new ArrayList<>();
        if (counter1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (counter2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
