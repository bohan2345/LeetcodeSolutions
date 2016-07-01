package google;

import utils.TreeNode;

/**
 * <p>
 * Created by Bohan Zheng on 6/30/2016.
 *
 * @author Bohan Zheng
 */
public class SecondSmallestINBiaryHeap {
    public int findSecond(TreeNode root) {
        int min = root.left.val;
        TreeNode minNode = root.left;
        if (root.right != null && root.right.val < root.left.val) {
            min = root.right.val;
            minNode = root.right;
        }
        if (min == root.val) {
            int second = findSecond(minNode);
            return Math.min(second, min);
        } else {
            return min;
        }
    }
}
