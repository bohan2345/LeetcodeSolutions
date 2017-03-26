package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 7/1/2016.
 *
 * @author Bohan Zheng
 */
public class GraphNode {
  public int value;
  public List<GraphNode> adjcents;

  public GraphNode(int value) {
    this.value = value;
    adjcents = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "GraphNode{" +
        "value=" + value +
        '}';
  }
}
