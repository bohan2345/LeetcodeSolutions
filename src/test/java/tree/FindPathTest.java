package tree;

import org.junit.Test;
import utils.MultiTreeNode;

import static com.google.common.truth.Truth.assertThat;

public class FindPathTest {
    private FindPath test = new FindPath();

    @Test
    public void test() {
        MultiTreeNode node1 = new MultiTreeNode(1);
        MultiTreeNode node2 = new MultiTreeNode(1);
        MultiTreeNode node3 = new MultiTreeNode(1);
        MultiTreeNode node4 = new MultiTreeNode(1);
        MultiTreeNode node5 = new MultiTreeNode(1);

        node1.children.add(node2);
        node1.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        MultiTreeNode nodeb1 = new MultiTreeNode(1);
        MultiTreeNode nodeb2 = new MultiTreeNode(1);
        MultiTreeNode nodeb3 = new MultiTreeNode(1);
        MultiTreeNode nodeb4 = new MultiTreeNode(1);
        MultiTreeNode nodeb5 = new MultiTreeNode(1);

        nodeb1.children.add(nodeb2);
        nodeb1.children.add(nodeb3);
        nodeb2.children.add(nodeb4);
        nodeb2.children.add(nodeb5);


        MultiTreeNode find = test.findPath(node1, node5, nodeb1);

        assertThat(find).isEqualTo(nodeb5);
    }
}
