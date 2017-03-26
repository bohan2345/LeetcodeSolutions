package linkedlist;

import utils.ListNode;
import utils.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * Created by Bohan Zheng on 2/16/2016.
 *
 * @author Bohan Zheng
 */
public class ConvertSortedListtoBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    return head == null ? null : construct(head, 0, getLength(head) - 1);
  }

  private int getLength(ListNode head) {
    int leng = 0;
    while (head != null) {
      leng++;
      head = head.next;
    }
    return leng;
  }

  private TreeNode construct(ListNode head, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    int i = mid;
    ListNode node = head;
    while (i > 0) {
      i--;
      node = node.next;
    }
    TreeNode treeNode = new TreeNode(node.val);
    treeNode.left = construct(head, start, mid - 1);
    treeNode.right = construct(node.next, 0, end - mid - 1);
    return treeNode;
  }
}
