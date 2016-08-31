package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 1/5/2016.
 *
 * @author Bohan Zheng
 */
public class CountCompleteTreeNodesTest {
  @Test
  public void test() {
    CountCompleteTreeNodes test = new CountCompleteTreeNodes();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
    assertEquals(3, test.countNodes(root));
  }

  @Test
  public void test2() {
    CountCompleteTreeNodes test = new CountCompleteTreeNodes();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1);
    assertEquals(1, test.countNodes(root));
  }

  @Test
  public void test3() {
    CountCompleteTreeNodes test = new CountCompleteTreeNodes();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4);
    assertEquals(4, test.countNodes(root));
  }

  @Test
  public void testNodeExists() {
    CountCompleteTreeNodes test = new CountCompleteTreeNodes();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4);
    assertTrue(test.nodeExists(root, 0, 3));
  }

  @Test
  public void testNodeExists2() {
    CountCompleteTreeNodes test = new CountCompleteTreeNodes();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4);
    assertTrue(!test.nodeExists(root, 1, 3));
  }

  @Test
  public void testNumOfNodesAtLastLvl() {
    CountCompleteTreeNodes test = new CountCompleteTreeNodes();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4);
    assertEquals(1, test.numOfNodesAtLastLvl(root, 3));
  }

  @Test
  public void testNumOfNodesAtLastLvl2() {
    CountCompleteTreeNodes test = new CountCompleteTreeNodes();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4, 5);
    assertEquals(2, test.numOfNodesAtLastLvl(root, 3));
  }
}
