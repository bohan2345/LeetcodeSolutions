package linkedlist;

import utils.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Created by Bohan Zheng on 2/11/16.
 *
 * @author Bohan Zheng
 */
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode fast = head.next, slow = head;
    while (fast != null) {
      if (fast.equals(slow)) {
        return true;
      }
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : fast.next;
    }
    return false;
  }
}
