package main;

import java.nio.file.AccessDeniedException;

/**
 * <br>
 * Created by Bohan Zheng on 9/10/2015.
 *
 * @author Bohan Zheng
 */
public class MainTest {
    public static void main(String[] args) {
        String[] strs = {"123","321"};
        System.out.println(1 & 1);
        Exception e = new AccessDeniedException("asdfasdfasdfasdf");
        System.out.println(e instanceof NullPointerException);
    }
}
