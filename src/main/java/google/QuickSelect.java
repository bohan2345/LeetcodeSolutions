package google;

/**
 * <p>
 * Created by Bohan Zheng on 6/13/2016.
 *
 * @author Bohan Zheng
 */
public class QuickSelect {
//    public void quickSort(int[] nums) {
//        int left = 0
//    }

    public int quickSelect(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int pivot = partition(nums, left, right, mid);
            if (pivot + 1 < k) {
                left = pivot + 1;
            } else if (pivot + 1 > k) {
                right = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return nums[left];
    }

    private int partition(int[] nums, int left, int right, int pivot) {
        int storeIndex = left;
        int pivotValue = nums[pivot];
        swap(nums, pivot, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
