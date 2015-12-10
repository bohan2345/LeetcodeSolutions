package main.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * utility class to simplify test for binary tree
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeUtils {
    public List<String> serializeBinaryTree(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add("#");
                continue;
            }
            res.add(Integer.toString(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            if (!res.get(i).equals("#")) {
                break;
            }
            res.remove(i);
        }
        return res;
    }

    public TreeNode constructBinaryTree(List<String> nodes) {
        TreeNode root = new TreeNode(Integer.valueOf(nodes.get(0)));
        return root;
    }
}
