package design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private Map<Integer, Integer> values; // key -> value
    private Map<Integer, Integer> frequency; // key -> frequency
    private Map<Integer, LinkedHashSet<Integer>> sameFreqLRU; // frequence -> set of key
    private int size;
    private int min;

    public LFUCache(int capacity) {
        values = new HashMap<>();
        frequency = new HashMap<>();
        sameFreqLRU = new HashMap<>();
        min = 0;
        size = capacity;
    }

    public int get(int key) {
        if (size == 0 || !values.containsKey(key)) {
            return -1;
        }

        sameFreqLRU.get(frequency.get(key)).remove(key);

        if (min == frequency.get(key) && sameFreqLRU.get(min).size() == 0) {
            sameFreqLRU.remove(min);
            min++;
        }

        frequency.put(key, frequency.get(key) + 1);
        LinkedHashSet<Integer> lhs = sameFreqLRU.getOrDefault(frequency.get(key), new LinkedHashSet<>());
        lhs.add(key);
        sameFreqLRU.put(frequency.get(key), lhs);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }

        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }

        if (values.keySet().size() == size) {
            LinkedHashSet<Integer> minList = sameFreqLRU.get(min);
            Integer keyWithMinFreq = minList.iterator().next();
            values.remove(keyWithMinFreq);
            frequency.remove(keyWithMinFreq);
            minList.remove(key);
            if (minList.size() == 0) {
                sameFreqLRU.remove(min);
            }
        }

        values.put(key, value);
        frequency.put(key, 1);
        LinkedHashSet<Integer> lhs = sameFreqLRU.getOrDefault(1, new LinkedHashSet<>());
        lhs.add(key);
        sameFreqLRU.put(1, lhs);
        min = 1;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
