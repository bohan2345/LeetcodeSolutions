package main.tree;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * Created by Bohan Zheng on 12/19/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curr = 1, next = 0;
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            level.add(node.val);
            curr--;
            if (curr == 0) {
                curr = next;
                next = 0;
                res.add(level);
                level = new ArrayList<>();
            }
        }
        return res;
    }
}
