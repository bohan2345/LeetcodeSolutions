package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ContinuousCharacterTest {
    @Test
    public void test() {
        ContinuousCharacter test = new ContinuousCharacter();
        List<Character> res = test.continuousChar("this send meet");
        assertThat(res).containsExactly('s', 'e');
    }

    @Test
    public void test2() {
        ContinuousCharacter test = new ContinuousCharacter();
        List<Character> res = test.continuousChar("this is pea");
        assertThat(res).containsExactlyElementsIn(getCharList("this is pea"));
    }

    @Test
    public void test3() {
        ContinuousCharacter test = new ContinuousCharacter();
        List<Character> res = test.continuousChar("a a a a a a a a a");
        assertThat(res).containsExactly('a');
    }

    private List<Character> getCharList(String s) {
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            characters.add(c);
        }
        return characters;
    }
}
