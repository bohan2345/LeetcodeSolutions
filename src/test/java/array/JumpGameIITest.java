package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JumpGameIITest {
  @Test
  public void testJump() {
    JumpGameII test = new JumpGameII();
    int[] A = {2, 3, 1, 1, 4};
    int[] B = {3, 2, 1, 0, 4};
    int[] C = {2, 1};

    assertEquals(2, test.jump(A));
    assertEquals(-1, test.jump(B));
    assertEquals(1, test.jump(C));
  }
}
