package design;

import java.util.*;

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class RandomizedCollection {

    /**
     * Initialize your data structure here.
     */

    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean result = false;
        if (!map.containsKey(val)) {
            result = true;
        }
        int size = list.size();
        Set<Integer> indices = map.getOrDefault(val, new HashSet<>());
        indices.add(size);
        map.put(val, indices);

        list.add(val);
        return result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index1 = map.get(val).iterator().next();
        int index2 = list.size() - 1;

        swap(index1, index2);

        map.get(val).remove(index1);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        list.remove(index2);
        return true;
    }

    private void swap(int i, int j) {
        int val1 = list.get(i);
        int val2 = list.get(j);

        list.set(i, val2);
        list.set(j, val1);

        map.get(val1).remove(i);
        map.get(val2).remove(j);
        map.get(val1).add(j);
        map.get(val2).add(i);
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int pos = rand.nextInt(list.size());
        return list.get(pos);
    }
}
