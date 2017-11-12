package fb;

import org.junit.Test;

import java.util.List;

public class RandomMinesTest {
    @Test
    public void test() {
        RandomMines test = new RandomMines();

        List<int[]> res = test.randomMines(4,4,4);

        for (int[] x : res) {
            System.out.print("(");
            System.out.print(x[0]);
            System.out.print(", ");
            System.out.print(x[1]);
            System.out.println(")");
        }

    }
}
