package array;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <br>
 * Created by Bohan Zheng on 9/30/2015.
 *
 * @author Bohan Zheng
 */
public class WordLadderIITest {
    WordLadderII test = new WordLadderII();

    @Test
    public void test() {
        String[] wordListArray = {"hot", "dot", "dog", "lot", "log"};
        Set<String> wordList = new HashSet<>(Arrays.asList(wordListArray));
        List<List<String>> actual = test.findLadders("hit", "cog", wordList);
        List<List<String>> expected = new ArrayList<>(2);
        expected.add(Arrays.asList(new String[]{"hit", "hot", "dot", "dog", "cog"}));
        expected.add(Arrays.asList(new String[]{"hit", "hot", "lot", "log", "cog"}));

        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void test2() {
        String[] wordListArray = {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"};
        Set<String> wordList = new HashSet<>(Arrays.asList(wordListArray));
        List<List<String>> actual = test.findLadders("red", "tax", wordList);
        List<List<String>> expected = new ArrayList<>(2);
        expected.add(Arrays.asList(new String[]{"red", "ted", "tad", "tax"}));
        expected.add(Arrays.asList(new String[]{"red", "ted", "tex", "tax"}));
        expected.add(Arrays.asList(new String[]{"red", "rex", "tex", "tax"}));

        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}
