package linkedlist;

import utils.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    ListNode dumy = new ListNode(0);
    dumy.next = head;
    ListNode prev = dumy, node = head;
    while (node != null) {
      if (node.val == val) {
        node = removeElementAfter(prev);
      } else {
        prev = node;
        node = node.next;
      }
    }
    return dumy.next;
  }

  private ListNode removeElementAfter(ListNode node) {
    if (node.next == null) {
      return node;
    }
    ListNode nodetoRemove = node.next;
    node.next = nodetoRemove.next;
    nodetoRemove.next = null;
    return node.next;
  }
}
