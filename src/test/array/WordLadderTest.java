package test.array;

import main.array.WordLadder;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 9/23/15.
 *
 * @author Bohan Zheng
 */
public class WordLadderTest {
    WordLadder test = new WordLadder();

    @Test
    public void test() {
        String[] wordListArray = {"hot", "dot", "dog", "lot", "log"};
        Set<String> wordList = new HashSet<>(Arrays.asList(wordListArray));
        test.ladderLength("hit", "cog", wordList);
        assertEquals(0, 0);
    }
}