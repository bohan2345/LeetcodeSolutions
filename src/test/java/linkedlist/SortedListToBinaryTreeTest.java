package linkedlist;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.LinkedListUtils;
import utils.ListNode;
import utils.TreeNode;

import static com.google.common.truth.Truth.assertThat;

public class SortedListToBinaryTreeTest {
    @Test
    public void test() {
        SortedListToBST test = new SortedListToBST();

        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4);

        TreeNode root = test.sortedListToBST(head);

        assertThat(BinaryTreeUtils.serialize(root)).isEqualTo("2,1,3,#,#,#,4");
    }


    @Test
    public void test2() {
        SortedListToBST test = new SortedListToBST();

        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5);

        TreeNode root = test.sortedListToBST(head);

        assertThat(BinaryTreeUtils.serialize(root)).isEqualTo("3,1,4,#,2,#,5");
    }
}
