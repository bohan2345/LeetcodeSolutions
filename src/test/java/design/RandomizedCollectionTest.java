package design;

import org.junit.Test;

public class RandomizedCollectionTest {
    @Test
    public void test() {
        RandomizedCollection test = new RandomizedCollection();

        test.insert(0);
        test.insert(2);
        test.insert(3);
        test.insert(3);
        test.insert(2);

        test.remove(2);
        test.remove(3);
        test.remove(0);

        test.getRandom();
        test.getRandom();
        test.getRandom();
        test.getRandom();
    }
}
