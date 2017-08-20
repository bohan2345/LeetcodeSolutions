package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * Created by Bohan Zheng on 1/12/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1, cur = 1, next = 0;
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (level % 2 == 1) {
                tmp.add(node.val);
            } else {
                tmp.add(0, node.val);
            }
            cur--;
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            if (cur == 0) {
                level++;
                cur = next;
                next = 0;
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        return res;
    }
}
