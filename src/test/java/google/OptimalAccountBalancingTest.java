package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptimalAccountBalancingTest {
    private OptimalAccountBalancing test = new OptimalAccountBalancing();

    @Test
    public void test() {
        int[][] transactions = {{0, 1, 10}, {2, 0, 5}};

        int min = test.minTransfers(transactions);

        assertEquals(2, min);
    }

    @Test
    public void test2() {
        //[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
        int[][] transactions = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};

        int min = test.minTransfers(transactions);

        assertEquals(1, min);
    }

    @Test
    public void test3() {
        int[][] transactions =
                {{1, 8, 1}, {1, 13, 21}, {2, 8, 10}, {3, 9, 20}, {4, 10, 61}, {5, 11, 61}, {6, 12, 59}, {7, 13, 60}};

        int min = test.minTransfers(transactions);

        assertEquals(8, min);
    }

    @Test
    public void test4() {
        int[][] transactions = {{1, 5, 8}, {8, 9, 8}, {2, 3, 9}, {4, 3, 1}};

        int min = test.minTransfers(transactions);

        assertEquals(4, min);
    }
}
