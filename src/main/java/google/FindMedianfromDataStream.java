package google;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * For example:
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3)
 * findMedian() -> 2
 * <p>
 * Created by Bohan Zheng on 6/10/2016.
 *
 * @author Bohan Zheng
 */
public class FindMedianfromDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianfromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(Integer.MIN_VALUE);
        minHeap = new PriorityQueue<>();
        minHeap.offer(Integer.MAX_VALUE);
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (num > minHeap.peek()) {
            minHeap.offer(num);
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        } else if (num < maxHeap.peek()) {
            maxHeap.offer(num);
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public void deleteNum(int num) {
        if (num >= minHeap.peek()) {
            minHeap.remove(num);
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            maxHeap.remove(num);
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
}
// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();