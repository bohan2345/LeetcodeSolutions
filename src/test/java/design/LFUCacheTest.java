package design;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LFUCacheTest {
    @Test
    public void test() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);
        assertThat(cache.get(2)).isEqualTo(-1);
    }
}
