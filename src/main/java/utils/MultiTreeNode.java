package utils;

import java.util.ArrayList;
import java.util.List;

public class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> children;

    public MultiTreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
