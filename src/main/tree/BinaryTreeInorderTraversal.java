package main.tree;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Created by Bohan Zheng on 12/18/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode n = root.left;
        while (!stack.isEmpty() || n != null) {
            if (n == null) {
            // node is the most left child
                TreeNode node = stack.pop();
                res.add(node.val);
                n = node.right;
            } else {
                stack.push(n);
                n = n.left;
            }
        }
        return res;
    }
}
