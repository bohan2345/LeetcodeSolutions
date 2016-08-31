package google;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 5/18/2016.
 *
 * @author Bohan Zheng
 */
public class FlipGameTest {
  @Test
  public void test() {
    FlipGame test = new FlipGame();
    assertThat(test.generatePossibleNextMoves("++++"),
        IsIterableContainingInAnyOrder.containsInAnyOrder("--++", "+--+", "++--"));
  }

  @Test
  public void test2() {
    FlipGame test = new FlipGame();
    assertThat(test.generatePossibleNextMoves("+-+++"),
        IsIterableContainingInAnyOrder.containsInAnyOrder("+---+", "+-+--"));
  }
}
