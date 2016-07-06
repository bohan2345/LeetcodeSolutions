package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/5/2016.
 *
 * @author Bohan Zheng
 */
public class CaesarCipher {
    public String encript(String str, int shift) {
        shift %= 26;
        if (shift < 0) {
            shift = shift + 26;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (c + shift > 'z') {
                int x = c + shift - 'z';
                c = (char) ('a' + x - 1);
            } else {
                c += shift;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
