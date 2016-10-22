package google;

import java.util.Stack;

/**
 * <p>
 * Created by Bohan Zheng on 6/13/2016.
 *
 * @author Bohan Zheng
 */
public class NutsBoltsProblem {
    public interface NBComparator {
        int compare(String nut, String bolt);
    }

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator comparator) {
        int left = 0, right = nuts.length - 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{left, right});
        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            left = pair[0];
            right = pair[1];
            if (left >= right) {
                break;
            }
            int mid = left + (right - 1) / 2;
            int pivot = partition(bolts, left, right, mid, nuts[mid], String::compareTo);
            partition(nuts, left, right, mid, bolts[pivot], String::compareTo);
            stack.push(new int[]{left, pivot - 1});
            stack.push(new int[]{pivot + 1, right});
        }
    }

    private int partition(String[] bolts, int left, int right, int pivot, String pivotValue, NBComparator comparator) {
        swap(bolts, right, pivot);
        int storedIndex = left;
        for (int i = left; i <= right; i++) {
            if (comparator.compare(pivotValue, bolts[i]) < 0) {
                swap(bolts, i, storedIndex);
                storedIndex++;
            }
        }
        swap(bolts, storedIndex, right);
        return storedIndex;
    }

    private void swap(String[] nums, int a, int b) {
        String tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
