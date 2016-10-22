package google;

/**
 * itoa() function in C language converts int data type to string data type.
 * <p>
 * Created by Bohan Zheng on 7/2/16.
 *
 * @author Bohan Zheng
 */
public class Itoa {
    public String itoa(int num, int base) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (num != 0) {
            sb.insert(0, chars[num % base]);
            num = num / base;
        }
        return sb.toString();
    }
}
