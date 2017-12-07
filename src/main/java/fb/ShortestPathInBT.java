package fb;

import utils.TreeNode;

public class ShortestPathInBT {
    int d1;
    int d2;
    int dLca;
    public int shortestPath(TreeNode root, TreeNode a, TreeNode b) {
        d1 = 0;
        d2 = 0;
        dLca = 0;

        lca(root, a, b, 0);
        return d1 + d2 - 2 * dLca;
    }

    private TreeNode lca(TreeNode n, TreeNode a, TreeNode b, int level) {
        if (n == null) {
            return null;
        }

        TreeNode leftResult = lca(n.left, a, b, level + 1);
        TreeNode rightResult = lca(n.right, a, b, level + 1);

        if (a == n && b == n) {
            d1 = level;
            d2 = level;
            dLca = level;
            return n;
        }

        if (a == n) {
            d1 = level;
            if (leftResult != null || rightResult != null) {
                dLca = level;
            }
            return n;
        }

        if (b == n) {
            d2 = level;
            if (leftResult != null || rightResult != null) {
                dLca = level;
            }
            return n;
        }

        if (leftResult != null && rightResult != null) {
            dLca = level;
            return n;
        }

        if (leftResult != null || rightResult != null) {
            return leftResult != null ? leftResult : rightResult;
        }
        return null;

    }
}
