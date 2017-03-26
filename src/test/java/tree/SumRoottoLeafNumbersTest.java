package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 12/22/2015.
 *
 * @author Bohan Zheng
 */
public class SumRoottoLeafNumbersTest {
  @Test
  public void test() {
    SumRoottoLeafNumbers test = new SumRoottoLeafNumbers();
    assertEquals(25, test.sumNumbers(BinaryTreeUtils.constructBinaryTree(1, 2, 3)));
  }

  @Test
  public void test2() {
    SumRoottoLeafNumbers test = new SumRoottoLeafNumbers();
    assertEquals(236, test.sumNumbers(BinaryTreeUtils.constructBinaryTree(1, 1, 1, 2, 3)));
  }
}
