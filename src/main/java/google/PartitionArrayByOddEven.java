package google;

/**
 * <p>
 * Created by Bohan Zheng on 6/15/2016.
 *
 * @author Bohan Zheng
 */
public class PartitionArrayByOddEven {
    public void partition(int[] arrays) {
        int evenIndex = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] % 2 == 0 && i != evenIndex) {
                int tmp = arrays[evenIndex];
                arrays[evenIndex] = arrays[i];
                arrays[i] = tmp;
                evenIndex++;
            }
        }
    }
}
