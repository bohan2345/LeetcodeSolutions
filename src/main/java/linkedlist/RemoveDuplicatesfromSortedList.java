package linkedlist;

import utils.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class RemoveDuplicatesfromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode node = head;
    while (node.next != null) {
      if (node.val == node.next.val) {
        removeAfter(node);
      } else {
        node = node.next;
      }
    }
    return head;
  }

  private void removeAfter(ListNode node) {
    if (node.next == null) {
      return;
    }
    ListNode nodeToRemove = node.next;
    node.next = nodeToRemove.next;
    nodeToRemove.next = null;
  }
}
