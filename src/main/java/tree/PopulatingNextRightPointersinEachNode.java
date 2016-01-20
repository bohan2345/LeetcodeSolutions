package tree;

import utils.TreeLinkNode;

/**
 * <p>
 * Created by Bohan Zheng on 12/30/15.
 *
 * @author Bohan Zheng
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode first = null;
        while (root != null) {
            if (first == null) {
                first = root.left;
            }
            if (root.left != null) {
                root.left.next = root.right;
            } else {
                break;
            }
            if (root.next != null) {
                root.right.next = root.next.left;
                root = root.next;
            } else {
                root = first;
                first = null;
            }
        }
    }
}
