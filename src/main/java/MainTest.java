
import java.nio.file.AccessDeniedException;

/**
 * <br>
 * Created by Bohan Zheng on 9/10/2015.
 *
 * @author Bohan Zheng
 */
public class MainTest {
    public static void main(String[] args) {
        B b = new B();
        callA(b);
    }

    static void callA(A a) {
        System.out.println(a.a);
    }

    public static class A {
        String a = "A";
    }

    public static class B extends A {
        String b = "B";
    }
}
