package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseNodesinKGroupTest {
  @Test
  public void test() {
    ReverseNodesinKGroup test = new ReverseNodesinKGroup();
    ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
    assertEquals("2,1,4,3,5", LinkedListUtils.serialize(test.reverseKGroup(head, 2)));
  }

  @Test
  public void test2() {
    ReverseNodesinKGroup test = new ReverseNodesinKGroup();
    ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);
    assertEquals("3,2,1,4,5", LinkedListUtils.serialize(test.reverseKGroup(head, 3)));
  }
}
