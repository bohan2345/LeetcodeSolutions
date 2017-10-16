package string;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class WordBreak1dot5Test {
    @Test
    public void test() {
        WordBreak1dot5 test = new WordBreak1dot5();

        String s = "abcd";
        List<String> dict = Arrays.asList("a", "b", "c", "d", "ab", "cd");

        String res = test.wordBreak(s, dict);

        assertThat(res).isIn(ImmutableList.of("a b c d ", "ab cd "));
    }


    @Test
    public void test2() {
        WordBreak1dot5 test = new WordBreak1dot5();

        String s = "abcd";
        List<String> dict = Arrays.asList("a", "b");

        String res = test.wordBreak(s, dict);

        assertThat(res).isNull();
    }
}
