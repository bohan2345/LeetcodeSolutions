package google;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 6/10/2016.
 *
 * @author Bohan Zheng
 */
public class SlidingWindowMedian {
  public List<Integer> medianSlidingWindow(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    FindMedianfromDataStream medianFinder = new FindMedianfromDataStream();
    int i = 0;
    for (; i < k; i++) {
      medianFinder.addNum(nums[i]);
    }
    Double d = medianFinder.findMedian();
    res.add(d.intValue());
    for (; i < nums.length; i++) {
      medianFinder.deleteNum(nums[i - k]);
      medianFinder.addNum(nums[i]);
      Double dd = medianFinder.findMedian();
      res.add(dd.intValue());
    }
    return res;
  }
}
