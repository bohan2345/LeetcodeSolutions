package google;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 7/7/16.
 *
 * @author Bohan Zheng
 */
public class BlackWhiteImageTest {

  @Test
  public void test() {
    BlackWhiteImage test = new BlackWhiteImage();
    BlackWhiteImage.QuadTreeNode root = new BlackWhiteImage.QuadTreeNode(-1);
    BlackWhiteImage.QuadTreeNode n1 = new BlackWhiteImage.QuadTreeNode(-1);
    BlackWhiteImage.QuadTreeNode n2 = new BlackWhiteImage.QuadTreeNode(0);
    BlackWhiteImage.QuadTreeNode n3 = new BlackWhiteImage.QuadTreeNode(0);
    BlackWhiteImage.QuadTreeNode n4 = new BlackWhiteImage.QuadTreeNode(-1);
    BlackWhiteImage.QuadTreeNode n11 = new BlackWhiteImage.QuadTreeNode(1);
    BlackWhiteImage.QuadTreeNode n12 = new BlackWhiteImage.QuadTreeNode(1);
    BlackWhiteImage.QuadTreeNode n13 = new BlackWhiteImage.QuadTreeNode(0);
    BlackWhiteImage.QuadTreeNode n14 = new BlackWhiteImage.QuadTreeNode(0);
    BlackWhiteImage.QuadTreeNode n41 = new BlackWhiteImage.QuadTreeNode(1);
    BlackWhiteImage.QuadTreeNode n42 = new BlackWhiteImage.QuadTreeNode(1);
    BlackWhiteImage.QuadTreeNode n43 = new BlackWhiteImage.QuadTreeNode(1);
    BlackWhiteImage.QuadTreeNode n44 = new BlackWhiteImage.QuadTreeNode(0);
    root.children[0] = n1;
    root.children[1] = n2;
    root.children[2] = n3;
    root.children[3] = n4;
    n1.children[0] = n11;
    n1.children[1] = n12;
    n1.children[2] = n13;
    n1.children[3] = n14;
    n4.children[0] = n41;
    n4.children[1] = n42;
    n4.children[2] = n43;
    n4.children[3] = n44;

    Assert.assertEquals((11.0d / 16.0d), test.blackPercentage(root), 0.0d);
  }
}
