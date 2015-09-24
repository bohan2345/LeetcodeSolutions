package main.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. <br>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).<br>
 * For reference, look here: <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">leetcode</a>
 * 
 * @author Bohan Zheng
 * 
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length, nt = n1 + n2;
		if (nt % 2 == 0) {
			return (findKBigestinTwoSortedArray(nums1, nums2, 0, 0, nt / 2)
					+ findKBigestinTwoSortedArray(nums1, nums2, 0, 0, (nt / 2) + 1)) / 2.0;
		} else {
			return findKBigestinTwoSortedArray(nums1, nums2, 0, 0, (nt / 2) + 1) * 1.0;
		}

	}

	private double findKBigestinTwoSortedArray(int[] nums1, int[] nums2, int left1, int left2, int k) {
		int len1 = nums1.length - left1;
		int len2 = nums2.length - left2;
		if (len1 == 0) {
			return nums2[left2 + k - 1];
		}
		if (len2 == 0) {
			return nums1[left1 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[left1], nums2[left2]);
		}

		int numsToRemove = Math.min(k / 2, Math.min(len1, len2));
		if (nums1[left1 + numsToRemove - 1] > nums2[left2 + numsToRemove - 1]) {
			return findKBigestinTwoSortedArray(nums1, nums2, left1, left2 + numsToRemove, k - numsToRemove);
		} else {
			return findKBigestinTwoSortedArray(nums1, nums2, left1 + numsToRemove, left2, k - numsToRemove);
		}
	}
}
