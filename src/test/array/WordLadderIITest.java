package test.array;

import main.array.WordLadderII;
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
        List<List<String>> actrual = test.findLadders("hit", "cog", wordList);
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"hit", "hot", "dot", "dog", "cog"}));
        expected.add(Arrays.asList(new String[]{"hit", "hot", "lot", "log", "cog"}));

        Assert.assertThat(actrual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}
