package miscellany;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate whether given string is valid JSON fromat string or not.
 * <p>
 * I/P: {a:b}
 * O/P: Yes Valid JSON
 * <p>
 * I/P: {a:b, c:d}
 * O/P: Yes Valid JSON
 * <p>
 * I/P: {a:b,c:{e:f}}
 * O/P Yes Valid JSON
 * <p>
 * I/P: {a}
 * O/p: not a valid json
 * <p>
 * I/P: {{a}}
 * O/P: not valid JSON
 * <p>
 * Created by Bohan Zheng on 3/8/2016.
 *
 * @author Bohan Zheng
 */
public class ValidJson {
    public boolean isValid(String jsonStr) {
        StringBuilder sb = new StringBuilder(jsonStr);
        boolean isValid = true;
        // extract leading and trailing braces
        if (sb.charAt(0) == '[' && sb.charAt(sb.length() - 1) == ']') {
            sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
            // validate each object
            String str = sb.toString();
            Pattern pattern = Pattern.compile("}\\s*,\\s*");
            Matcher matcher = pattern.matcher(sb.toString());
            int start = 0, end = 0;
            while (matcher.find(end)) {
                start = matcher.start();
                String obj = str.substring(end, start + 1);
                end = matcher.end();
                isValid = isValid && isValid(obj);
            }
            isValid = isValid && isValid(str.substring(end));
        } else {
            isValid = sb.charAt(0) == '{' && sb.charAt(sb.length() - 1) == '}';
            sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
            // validate each key value pair
            String[] pairs = sb.toString().split("\\s*,\\s*");
            for (String pair : pairs) {
                int i = pair.indexOf(':');
                if (i == -1) {
                    return false;
                }
                String key = pair.substring(0, i);
                String value = pair.substring(i + 1);
                isValid = isValid && key.matches("\\s*[a-zA-Z]+\\s*");
                isValid = isValid && (value.matches("\\s*[a-zA-Z]+\\s*") || isValid(value));
            }
        }
        return isValid;
    }
}
