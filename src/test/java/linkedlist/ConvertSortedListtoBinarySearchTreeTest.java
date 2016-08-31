package linkedlist;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.LinkedListUtils;
import utils.ListNode;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class ConvertSortedListtoBinarySearchTreeTest {
  @Test
  public void test() {
    ConvertSortedListtoBinarySearchTree test = new ConvertSortedListtoBinarySearchTree();
    ListNode head = LinkedListUtils.constructLinkedList(1, 2);
    assertEquals(1, test.sortedListToBST(head).val);
  }

  @Test
  public void test2() {
    ConvertSortedListtoBinarySearchTree test = new ConvertSortedListtoBinarySearchTree();
    ListNode head = LinkedListUtils.constructLinkedList(3, 5, 8);
    TreeNode root = BinaryTreeUtils.constructBinaryTree(5, 3, 8);
    assertEquals(BinaryTreeUtils.serialize(root), BinaryTreeUtils.serialize(test.sortedListToBST(head)));
  }
}
