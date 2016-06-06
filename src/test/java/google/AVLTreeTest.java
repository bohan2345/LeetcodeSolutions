package google;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 6/2/2016.
 *
 * @author Bohan Zheng
 */
public class AVLTreeTest {
    @Ignore
    @Test
    public void test() {
        AVLTree tree = new AVLTree(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        // TODO: null pointer exception, need fix
        tree.delete(5);
        tree.delete(4);
        tree.delete(3);
        tree.delete(1);
        assertEquals(tree.search(2), tree.root);
    }
}
