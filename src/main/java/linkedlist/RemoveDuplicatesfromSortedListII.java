package linkedlist;

import utils.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class RemoveDuplicatesfromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode dumy = new ListNode(0);
    dumy.next = head;
    ListNode prev = dumy, node = head;
    boolean isDuplicate = false;
    while (node.next != null) {
      if (node.val == node.next.val) {
        isDuplicate = true;
        removeAfter(node);
      } else {
        if (isDuplicate) {
          node = removeAfter(prev);
          isDuplicate = false;
        } else {
          prev = node;
          node = node.next;
        }
      }
    }
    if (isDuplicate) {
      removeAfter(prev);
    }
    return dumy.next;
  }

  private ListNode removeAfter(ListNode node) {
    if (node.next == null) {
      return node;
    }
    ListNode nodetoRemove = node.next;
    node.next = nodetoRemove.next;
    nodetoRemove.next = null;
    return node.next;
  }
}
