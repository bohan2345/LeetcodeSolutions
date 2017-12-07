package fb;

import java.util.*;

public class TaskScheduler {
//    public int leastInterval(char[] tasks, int n) {
//        int[] counts = new int[26];
//        for (char task : tasks) {
//            counts[task - 'A']++;
//        }
//        int k = 0;
//        int maxCount = 0;
//        for (int count : counts) {
//            if (count > maxCount) {
//                maxCount = count;
//                k = 1;
//            } else if (count == maxCount) {
//                k++;
//            }
//        }
//        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + k);
//    }

    class ReturnType {
        Integer times;
        Character c;

        public ReturnType(Integer times, Character c) {
            this.times = times;
            this.c = c;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> occur = new HashMap<>();
        Map<Character, Integer> valid = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            occur.put(tasks[i], occur.getOrDefault(tasks[i], 0) + 1);
            valid.put(tasks[i], 0);
        }

        TreeMap<Integer, List<Character>> bst = new TreeMap<>(Comparator.reverseOrder());
        for (Character c : occur.keySet()) {
            List<Character> tmp = bst.getOrDefault(occur.get(c), new ArrayList<>());
            tmp.add(c);
            bst.put(occur.get(c), tmp);
        }

        int len = 0;
        int used = 0;
        while (used < tasks.length) {

            ReturnType task = getMostAndValid(bst, valid, len);
            if (task != null) {
                bst.get(task.times).remove(task.c);
                if (task.times > 1) {
                    List<Character> tmp = bst.getOrDefault(task.times - 1, new ArrayList<>());
                    tmp.add(task.c);
                    bst.put(task.times - 1, tmp);
                }
                valid.put(task.c, len + n + 1);
                used++;
            }
            len++;

        }
        return len;
    }

    private ReturnType getMostAndValid(TreeMap<Integer, List<Character>> bst, Map<Character, Integer> valid, int len) {
        for (Integer times : bst.keySet()) {
            for (Character c : bst.get(times)) {
                if (valid.get(c) <= len) {
                    return new ReturnType(times, c);
                }
            }
        }

        return null;
    }
}
