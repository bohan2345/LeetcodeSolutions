package google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ReplaceStringGameTest {
    @Test
    public void test() {
        ReplaceStringGame test = new ReplaceStringGame();
        List<String[]> rules = new ArrayList<>();
        rules.add(new String[]{"aa", "ab"});
        rules.add(new String[]{"abab", "b"});
        rules.add(new String[]{"aaaba", "f"});

        boolean res = test.replaceStringGame("aaaba", rules);

        assertThat(res).isTrue();
    }
}
