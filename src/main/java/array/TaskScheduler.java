package array;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        int k = 0;
        int maxCount = 0;
        for (int count : counts) {
            if (count > maxCount) {
                maxCount = count;
                k = 1;
            } else if (count == maxCount) {
                k++;
            }
        }
        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + k);
    }
}
