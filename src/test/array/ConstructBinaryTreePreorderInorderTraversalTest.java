package test.array;

import main.array.ConstructBinaryTreePreorderInorderTraversal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class ConstructBinaryTreePreorderInorderTraversalTest {
    ConstructBinaryTreePreorderInorderTraversal test = new ConstructBinaryTreePreorderInorderTraversal();

    @Test
    public void test() {
        test.buildTree(new int[]{1, 2}, new int[]{2, 1});
        assertEquals(0, 0);
    }
}
