package google;

import java.util.Random;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class RandomArray {
    public int[] randomArray(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        shuffle(nums);
        return nums;
    }

    public void shuffle(int[] nums) {
        Random r = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int random = r.nextInt(i + 1);
            swap(nums, i, random);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
