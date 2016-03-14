package string;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 3/14/2016.
 *
 * @author Bohan Zheng
 */
public class TextJustificationTest {
    @Test
    public void test() {
        TextJustification test = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> expected = new ArrayList<>();
        expected.add("This    is    an");
        expected.add("example  of text");
        expected.add("justification.  ");
        assertThat(test.fullJustify(words, 16), IsIterableContainingInOrder.contains(expected.toArray()));
    }

    @Test
    public void test2() {
        TextJustification test = new TextJustification();
        String[] words = {"What","must","be","shall","be."};
        List<String> expected = new ArrayList<>();
        expected.add("What must be");
        expected.add("shall be.   ");
        assertThat(test.fullJustify(words, 12), IsIterableContainingInOrder.contains(expected.toArray()));
    }
}
