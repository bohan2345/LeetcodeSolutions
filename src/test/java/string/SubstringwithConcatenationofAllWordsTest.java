package string;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 3/9/2016.
 *
 * @author Bohan Zheng
 */
public class SubstringwithConcatenationofAllWordsTest {
  @Test
  public void test() {
    SubstringwithConcatenationofAllWords test = new SubstringwithConcatenationofAllWords();
    assertThat(test.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}),
        IsIterableContainingInAnyOrder.containsInAnyOrder(0, 9));
  }

  @Test
  public void test2() {
    SubstringwithConcatenationofAllWords test = new SubstringwithConcatenationofAllWords();
    assertThat(test.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}),
        IsIterableContainingInAnyOrder.containsInAnyOrder(8));
  }
}
