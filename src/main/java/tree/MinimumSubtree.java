package tree;

import utils.TreeNode;

/**
 * Created by bohan on 2/4/2017.
 *
 * @author Bohan Zheng
 */
public class MinimumSubtree {
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        return divideAndConquer(root).minSumTreeNode;
    }

    private ResultType divideAndConquer(TreeNode n) {
        if (n == null) {
            return new ResultType(0, Integer.MAX_VALUE, null);
        }

        if (n.left == null && n.right == null) {
            return new ResultType(n.val, n.val, n);
        }

        ResultType leftNode = divideAndConquer(n.left);
        ResultType rightNode = divideAndConquer(n.right);

        int sum = leftNode.sum + rightNode.sum + n.val;
        if (sum < leftNode.minSum && sum < rightNode.minSum) {
            return new ResultType(sum, sum, n);
        }

        if (leftNode.minSum < rightNode.minSum) {
            return new ResultType(sum, leftNode.minSum, leftNode.minSumTreeNode);
        } else {
            return new ResultType(sum, rightNode.minSum, rightNode.minSumTreeNode);
        }
    }

    private class ResultType {
        int sum;
        int minSum;
        TreeNode minSumTreeNode;

        ResultType(int s, int m, TreeNode node) {
            sum = s;
            minSum = m;
            minSumTreeNode = node;
        }
    }
}