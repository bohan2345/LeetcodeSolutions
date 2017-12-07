package fb;

import org.junit.Test;
import utils.TreeNode;

import static com.google.common.truth.Truth.assertThat;

public class ShortestPathInBTest {
    @Test
    public void test() {
        ShortestPathInBT test = new ShortestPathInBT();

        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        root.left = a;
        root.right = b;

        int dist = test.shortestPath(root, a, b);

        assertThat(dist).isEqualTo(2);

        int dist2 = test.shortestPath(root, root, a);

        assertThat(dist2).isEqualTo(1);

        int dist3 = test.shortestPath(root, a, a);

        assertThat(dist3).isEqualTo(0);
    }

    @Test
    public void test2() {
        ShortestPathInBT test = new ShortestPathInBT();

        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        root.left = a;
        a.left = b;
        a.right = c;

        int dist = test.shortestPath(root, b, c);

        assertThat(dist).isEqualTo(2);

    }
}
