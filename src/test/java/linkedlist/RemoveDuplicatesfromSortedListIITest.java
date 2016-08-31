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
public class RemoveDuplicatesfromSortedListIITest {
  @Test
  public void test() {
    ListNode head = LinkedListUtils.constructLinkedList(1, 1, 2, 3, 3);
    RemoveDuplicatesfromSortedListII test = new RemoveDuplicatesfromSortedListII();
    assertEquals("2", LinkedListUtils.serialize(test.deleteDuplicates(head)));
  }
}
