package tree;

import utils.TreeLinkNode;

/**
 * <p>
 * Created by Bohan Zheng on 12/30/15.
 *
 * @author Bohan Zheng
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode first = null, last = null;
        while (root != null) {
            if (first == null) {
                first = root.left == null ? root.right : root.left;
            }
            if (root.left != null) {
                if (last != null) {
                    last.next = root.left;
                }
                last = root.left;
            }
            if (root.right != null) {
                if (last != null) {
                    last.next = root.right;
                }
                last = root.right;
            }
            if (root.next != null) {
                root = root.next;
            } else {
                root = first;
                first = null;
                last = null;
            }
        }
    }
}
