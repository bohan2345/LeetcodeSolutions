package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/27/2016.
 *
 * @author Bohan Zheng
 */
public class SwapNodesinPairsTest {
  @Test
  public void test() {
    SwapNodesinPairs test = new SwapNodesinPairs();
    ListNode head = LinkedListUtils.constructLinkedList(1);
    assertEquals("1", LinkedListUtils.serialize(test.swapPairs(head)));
  }

  @Test
  public void test2() {
    SwapNodesinPairs test = new SwapNodesinPairs();
    ListNode head = LinkedListUtils.constructLinkedList(1, 2);
    assertEquals("2,1", LinkedListUtils.serialize(test.swapPairs(head)));
  }

  @Test
  public void test3() {
    SwapNodesinPairs test = new SwapNodesinPairs();
    ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3);
    assertEquals("2,1,3", LinkedListUtils.serialize(test.swapPairs(head)));
  }

  @Test
  public void test4() {
    SwapNodesinPairs test = new SwapNodesinPairs();
    ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4);
    assertEquals("2,1,4,3", LinkedListUtils.serialize(test.swapPairs(head)));
  }
}
