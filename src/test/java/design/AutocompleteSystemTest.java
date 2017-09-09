package design;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class AutocompleteSystemTest {
    @Test
    public void test() {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem system = new AutocompleteSystem(sentences, times);
        assertThat(system.input('i')).containsExactly("i love you", "island", "i love leetcode").inOrder();
        assertThat(system.input(' ')).containsExactly("i love you","i love leetcode").inOrder();
        assertThat(system.input('a')).isEmpty();
        assertThat(system.input('#')).isEmpty();
        assertThat(system.input('i')).containsExactly("i love you", "island", "i love leetcode").inOrder();
        assertThat(system.input(' ')).containsExactly("i love you","i love leetcode", "i a").inOrder();
        assertThat(system.input('a')).containsExactly("i a").inOrder();
    }
}
