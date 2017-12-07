package fb;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class FindSamePatternTest {
    @Test
    public void test() {
        FindSamePattern test = new FindSamePattern();

        List<List<String>> res = test.findSamePattern(ImmutableList.of("aba", "cbc", "aab", "xxa"));

        assertThat(res).containsExactlyElementsIn(
                ImmutableList.of(ImmutableList.of("aba", "cbc"), ImmutableList.of("aab", "xxa")));
    }
}
