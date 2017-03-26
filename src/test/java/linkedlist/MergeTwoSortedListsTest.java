package linkedlist;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class MergeTwoSortedListsTest {
  @Test
  public void test() {
    ListNode l1 = LinkedListUtils.constructLinkedList(1, 3, 5);
    ListNode l2 = LinkedListUtils.constructLinkedList(2, 4);
    MergeTwoSortedLists test = new MergeTwoSortedLists();
    assertEquals("1,2,3,4,5", LinkedListUtils.serialize(test.mergeTwoLists(l1, l2)));
  }
}
