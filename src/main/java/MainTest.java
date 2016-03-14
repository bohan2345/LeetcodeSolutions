/**
 * <br>
 * Created by Bohan Zheng on 9/10/2015.
 *
 * @author Bohan Zheng
 */
public class MainTest {
    public static void main(String[] args) {
        int x = (int) Math.ceil(3 / (2 * 1.0));
        System.out.print(x);
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
