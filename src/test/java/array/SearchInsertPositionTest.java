package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPositionTest {
  @Test
  public void searchInsertTest() {
    SearchInsertPosition test = new SearchInsertPosition();
    int[] nums = {1, 3, 5, 6};
    assertEquals(2, test.searchInsert(nums, 5));
    assertEquals(1, test.searchInsert(nums, 2));
    assertEquals(4, test.searchInsert(nums, 7));
    assertEquals(0, test.searchInsert(nums, 0));
  }
}
