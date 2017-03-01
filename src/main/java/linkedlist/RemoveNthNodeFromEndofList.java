package linkedlist;

import utils.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class RemoveNthNodeFromEndofList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode node = head;
    ListNode nodeWaitForRemove = head;
    for (; n > 0; n--) {
      node = node.next;
    }
    ListNode prev = new ListNode(0);
    ListNode newHead = prev;
    prev.next = nodeWaitForRemove;
    while (node != null) {
      prev = nodeWaitForRemove;
      nodeWaitForRemove = nodeWaitForRemove.next;
      node = node.next;
    }
    prev.next = nodeWaitForRemove.next;
    nodeWaitForRemove.next = null;
    return newHead.next;
  }
}
