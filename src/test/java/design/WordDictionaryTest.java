package design;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class WordDictionaryTest {
    @Test
    public void test() {
        WordDictionary test = new WordDictionary();
        test.addWord("cba");
        test.addWord("cdd");
        test.addWord("cdf");
        assertThat(test.search("cd.")).containsExactly("cdd", "cdf");
        assertThat(test.search("c..")).containsExactly("cba", "cdd", "cdf");
        assertThat(test.search("c...")).isEmpty();
        test.addWord("cbcd");
        assertThat(test.search("c...")).containsExactly("cbcd");
        test.addWord("abcd");
        assertThat(test.search("....")).containsExactly("cbcd", "abcd");
    }
}
