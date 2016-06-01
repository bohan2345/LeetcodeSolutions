package google;

/**
 * <p>
 * Created by Bohan Zheng on 6/1/2016.
 *
 * @author Bohan Zheng
 */
public class ValidPreorderTraversal {
    public boolean isValid(String order) {
        StringBuilder sb = new StringBuilder(order);
        int i = 0;
        while (sb.length() > 1 && sb.indexOf("##") != -1) {
            i = sb.indexOf("##", i);
            if (i == -1) {
                i = 0;
                continue;
            }
            sb.delete(i - 1, i + 2);
            sb.insert(i - 1, '#');
        }
        return sb.length() == 1;
    }
}
