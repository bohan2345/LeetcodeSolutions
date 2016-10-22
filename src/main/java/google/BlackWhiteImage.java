package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/7/16.
 *
 * @author Bohan Zheng
 */
public class BlackWhiteImage {
    public double blackPercentage(QuadTreeNode root) {
        if (!root.hasChild()) {
            return root.val == 0 ? 1.0 : 0d;
        }
        double a = blackPercentage(root.children[0]);
        double b = blackPercentage(root.children[1]);
        double c = blackPercentage(root.children[2]);
        double d = blackPercentage(root.children[3]);
        return (a + b + c + d) / 4;
    }

    /**
     * 把白色视为不透明，黑色视为透明，重叠在一起, 只有两个images都是黑merge后才是黑，其他都是白。
     */
    public QuadTreeNode combine(QuadTreeNode root1, QuadTreeNode root2) {
        QuadTreeNode root = new QuadTreeNode(-1);
        if (!root1.hasChild() && !root2.hasChild()) {
            int val = root1.val == 0 && root2.val == 0 ? 0 : 1;
            root.val = val;
            return root;
        }
        if (!root1.hasChild()) {
            if (root1.val == 0) {
                return root2;
            } else {
                return root1;
            }
        }
        if (!root2.hasChild()) {
            if (root2.val == 0) {
                return root1;
            } else {
                return root2;
            }
        }
        root.children[0] = combine(root1.children[0], root2.children[0]);
        root.children[1] = combine(root1.children[1], root2.children[1]);
        root.children[2] = combine(root1.children[2], root2.children[2]);
        root.children[3] = combine(root1.children[3], root2.children[3]);
        return root;
    }

    public static class QuadTreeNode {
        int val;
        QuadTreeNode[] children;

        public QuadTreeNode(int value) {
            this.val = value;
            children = new QuadTreeNode[4];
        }

        public boolean hasChild() {
            return children[0] != null || children[1] != null
                    || children[2] != null || children[3] != null;
        }
    }
}
