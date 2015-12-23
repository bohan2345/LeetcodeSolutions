package main.tree;

import main.utils.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 * <p>
 * Created by Bohan Zheng on 12/22/2015.
 *
 * @author Bohan Zheng
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[1];
        dfsHelper(root, 0, sum);
        return sum[0];
    }

    private void dfsHelper(TreeNode root, int tmpNum, int[] sum) {
        if (root.left == null && root.right == null) {
            sum[0] += tmpNum * 10 + root.val;
            return;
        }
        if (root.left != null) {
            dfsHelper(root.left, tmpNum * 10 + root.val, sum);
        }
        if (root.right != null) {
            dfsHelper(root.right, tmpNum * 10 + root.val, sum);
        }
    }
}
