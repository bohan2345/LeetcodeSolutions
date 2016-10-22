package google;

import java.util.TreeSet;

/**
 * nums = [5,2,6,1]
 * return [2,1,1,0]
 * <p>
 * Created by Bohan Zheng on 6/1/2016.
 *
 * @author Bohan Zheng
 */
public class CountSmallerNumberAfterSelf {
    // use a binary search tree, in each node maintain the size the tree under that node.
    // loop nums[] from right to left. when inserting each number nums[i], count the number of node less than nums[i]
    public int[] count(int[] nums) {
        int[] res = new int[nums.length];
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            bst.add(nums[i]);
            res[i] = bst.lower(nums[i]);
        }
        return res;
    }
}
