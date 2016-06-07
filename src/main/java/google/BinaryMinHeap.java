package google;

/**
 * <p>
 * Created by Bohan Zheng on 6/6/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryMinHeap {
    private int[] array;
    private int i;

    public BinaryMinHeap() {
        this(10);
    }

    public BinaryMinHeap(int size) {
        array = new int[size];
        i = 0;
    }

    public BinaryMinHeap(int[] nums) {
        this(nums.length);
        for (int n : nums) {
            insert(n);
        }
    }

    public void insert(int num) {
        array[i] = num;
        int j = i;
        i++;
        // heapify, move up
        while (j > 0) {
            int parent = (j - 1) / 2;
            if (array[parent] > array[j]) {
                int tmp = array[parent];
                array[parent] = array[j];
                array[j] = tmp;
                j = parent;
            } else {
                break;
            }
        }
    }

    public int extract() {
        int num = array[0];
        array[0] = array[i - 1];
        array[i - 1] = 0;
        i--;
        // heapify, move down
        int j = 0;
        while (j < i) {
            int left = (j + 1) * 2 - 1;
            int right = (j + 1) * 2;
            int min = j;
            // find minimum in array[left, right, min]
            if (left < i && array[left] < array[min]) {
                min = left;
            }
            if (right < i && array[right] < array[min]) {
                min = right;
            }
            // if array[min] is not the minimum
            if (min != j) {
                int tmp = array[min];
                array[min] = array[j];
                array[j] = tmp;
                j = min;
            } else {
                break;
            }
        }
        return num;
    }
}
