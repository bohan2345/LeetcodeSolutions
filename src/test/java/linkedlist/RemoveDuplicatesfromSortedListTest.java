package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class RemoveDuplicatesfromSortedListTest {
  @Test
  public void test() {
    ListNode head = LinkedListUtils.constructLinkedList(1, 1, 2, 3, 3, 3);
    RemoveDuplicatesfromSortedList test = new RemoveDuplicatesfromSortedList();
    assertEquals("1,2,3", LinkedListUtils.serialize(test.deleteDuplicates(head)));
  }

  @Test
  public void test2() {
    ListNode head = LinkedListUtils.constructLinkedList(1);
    RemoveDuplicatesfromSortedList test = new RemoveDuplicatesfromSortedList();
    assertEquals("1", LinkedListUtils.serialize(test.deleteDuplicates(head)));
  }
}
