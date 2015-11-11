package main.array;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.<p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Created by Bohan Zheng on 11/10/2015.
 *
 * @author Bohan Zheng
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Because the majority element must more than other elements, set a counter and iterate through the element, every
     * time see a majority element counter++, counter-- on other elements, after iteration counter will be greater than 0.
     * And all other element is less than majority element, their counter will less than 0.
     *
     * 1. suppose the 1st element n is majority element, counter = 0;
     * 2. iterate throught the array, if nums[i] == n counter++ else counter--
     * 3. if counter == 0, set the current element as a new majority element candidiate.
     * 4. the element left after the iteration must be the majority element.
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int candidate = nums[0], counter = 0;
        for (int n : nums) {
            if (n == candidate) {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                counter = 1;
                candidate = n;
            }
        }
        // if the majority element not always exists, add a check here
        /*
        counter = 0;
        for (int n : nums) {
            if (n == candidate)
                counter++;
        }
        if (counter > nums.length / 2)
            return candidate;
        else
            throw new RuntimeException("not exist");
        */
        return candidate;
    }
}
