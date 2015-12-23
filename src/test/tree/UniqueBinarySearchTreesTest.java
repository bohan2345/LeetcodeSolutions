package test.tree;

import main.tree.UniqueBinarySearchTrees;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 12/20/15.
 *
 * @author Bohan Zheng
 */
public class UniqueBinarySearchTreesTest {
    @Test
    public void test() {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        assertEquals(1, test.numTrees(1));
    }

    @Test
    public void test1() {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        assertEquals(2, test.numTrees(2));
    }

    @Test
    public void test2() {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        assertEquals(5, test.numTrees(3));
    }
}