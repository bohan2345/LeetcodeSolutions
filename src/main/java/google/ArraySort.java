package google;

import utils.ArrayUtils;

/**
 * <p>
 * Created by Bohan Zheng on 7/6/2016.
 *
 * @author Bohan Zheng
 */
public class ArraySort {
  public void mergeSort(int[] nums) {
    if (nums == null) {
      return;
    }
    mergeSortHelper(nums, 0, nums.length - 1, new int[nums.length]);
  }

  private void mergeSortHelper(int[] nums, int left, int right, int[] tmp) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSortHelper(nums, left, mid, tmp);
    mergeSortHelper(nums, mid + 1, right, tmp);
    int i = left, j = mid + 1;
    for (int k = left; k <= right; k++) {
      if (j > right || (nums[i] < nums[j] && i <= mid)) {
        tmp[k] = nums[i];
        i++;
      } else {
        tmp[k] = nums[j];
        j++;
      }
    }
    for (; left <= right; left++) {
      nums[left] = tmp[left];
    }
  }

  public void quickSort(int[] nums) {
    quickSortHelper(nums, 0, nums.length - 1);
  }

  private void quickSortHelper(int[] nums, int left, int right) {
    if (left > right) {
      return;
    }
    int pivot = partition(nums, left, right, left);
    quickSortHelper(nums, left, pivot - 1);
    quickSortHelper(nums, pivot + 1, right);
  }

  private int partition(int[] nums, int left, int right, int pivot) {
    int pivotValue = nums[pivot];
    ArrayUtils.swap(nums, pivot, right);
    int index = left;
    for (int i = left; i < right; i++) {
      if (nums[i] < pivotValue) {
        ArrayUtils.swap(nums, index, i);
        index++;
      }
    }
    ArrayUtils.swap(nums, right, index);
    return index;
  }

  public void heapSort(int[] A) {
    heapify(A);
    for (int last = A.length - 1; last > 0; last--) {
      swap(A, 0, last);
      shiftDown(A, 0, last);
    }
  }

  // build heap
  private void heapify(int[] A) {
    int count = A.length;
    // find the last element's parent, last element is at index (count - 1)
    // parent is at (index - 1) / 2
    int index = (count - 2) / 2;
    for (int i = index; i >= 0; i--) {
      shiftDown(A, i, count);
    }
  }

  // reorder the heap, maintain a max-heap
  private void shiftDown(int[] A, int index, int len) {
    int root = index;
    while (root * 2 + 1 < len) { // ensure this root has at least one child.
      int left = root * 2 + 1;
      int swap = left;
      if (left + 1 < len) { // right child exist
        int right = left + 1;
        swap = A[left] > A[right] ? left : right;
      }
      if (A[root] < A[swap]) {
        swap(A, root, swap);
        root = swap;
      } else {
        break;
      }
    }
  }

  private void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }
}
