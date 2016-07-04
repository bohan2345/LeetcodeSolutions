package google;

import utils.TreeNode;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class LowestCommonAncestorofaBinarySearchTreeII {
    public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        boolean[] finded = {false, false};
        TreeNode ancestor = search(root, node1, node2, finded);
        if (finded[0] && finded[1]) {
            return ancestor;
        } else {
            return null;
        }
    }

    private TreeNode search(TreeNode root, TreeNode node1, TreeNode node2, boolean[] finded) {
        if (root == null) {
            return null;
        }
        TreeNode n1 = search(root.left, node1, node2, finded);
        TreeNode n2 = search(root.right, node1, node2, finded);
        if (node1.equals(root)) {
            finded[0] = true;
            return root;
        }
        if (node2.equals(root)) {
            finded[1] = true;
            return root;
        }

        if (n1 != null && n2 != null) {
            return root;
        } else if (n1 != null) {
            return n1;
        } else if (n2 != null) {
            return n2;
        } else {
            return null;
        }
    }
}
