package design;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ReadLineTest {
    @Test
    public void test1() {
        ReadLine test = new ReadLine();
        test.setFile("abcdefg\nasdf\n\t\tasdfasdf\na");
        assertThat(test.readLine()).isEqualTo("abcdefg");
        assertThat(test.readLine()).isEqualTo("asdf");
        assertThat(test.readLine()).isEqualTo("\t\tasdfasdf");
        assertThat(test.readLine()).isEqualTo("a");
    }

    @Test
    public void test2() {
        ReadLine test = new ReadLine();
        test.setFile("\n\n\n\n\n");
        assertThat(test.readLine()).isEqualTo("");
        assertThat(test.readLine()).isEqualTo("");
        assertThat(test.readLine()).isEqualTo("");
        assertThat(test.readLine()).isEqualTo("");
    }

    @Test
    public void test3() {
        ReadLine test = new ReadLine();
        test.setFile("asdfghjkl");
        assertThat(test.readLine()).isEqualTo("asdfghjkl");
        assertThat(test.readLine()).isEqualTo("");
    }
}
