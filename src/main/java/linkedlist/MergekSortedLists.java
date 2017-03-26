package linkedlist;

import utils.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class MergekSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    return mergeKLists(lists, 0, lists.length - 1);
  }

  private ListNode mergeKLists(ListNode[] lists, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return lists[left];
    }
    int mid = left + (right - left) / 2;
    ListNode l1 = mergeKLists(lists, left, mid);
    ListNode l2 = mergeKLists(lists, mid + 1, right);
    return merge(l1, l2);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode newHead = new ListNode(0);
    ListNode node = newHead;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        node.next = l2;
        l2 = l2.next;
      } else {
        node.next = l1;
        l1 = l1.next;
      }
      node = node.next;
    }
    node.next = l1 == null ? l2 : l1;
    return newHead.next;
  }
}
