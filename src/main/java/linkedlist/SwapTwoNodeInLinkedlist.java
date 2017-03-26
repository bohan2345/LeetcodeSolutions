package linkedlist;

import utils.ListNode;

/**
 * Created by bohan on 9/27/2016.
 *
 * @author Bohan Zheng
 */
public class SwapTwoNodeInLinkedlist {
  public ListNode swapNodes(ListNode head, int a, int b) {
    ListNode prev = new ListNode(0);
    ListNode tmp = prev;
    prev.next = head;
    ListNode prev1 = null;
    ListNode prev2 = null;
    while (prev.next != null) {
      if (prev.next.val == a) {
        prev1 = prev;
      }
      if (prev.next.val == b) {
        prev2 = prev;
      }
      prev = prev.next;
    }
    swapNodeAfter(prev1, prev2);
    return tmp.next;
  }

  private void swapNodeAfter(ListNode prev1, ListNode prev2) {
    if (prev1 == null || prev2 == null) {
      return;
    }
    ListNode node1 = prev1.next;
    ListNode node2 = prev2.next;
    ListNode next1 = node1.next;
    ListNode next2 = node2.next;
    if (node2.equals(node1.next)) {
      prev1.next = node2;
      node2.next = node1;
      node1.next = next2;
    } else if (node1.equals(node2.next)) {
      prev2.next = node1;
      node1.next = node2;
      node2.next = next1;
    } else {
      // swap
      prev1.next = node2;
      node2.next = next1;
      prev2.next = node1;
      node1.next = next2;
    }
  }
}
