package google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class SequenceReconstructionTest {
    private SequenceReconstruction test = new SequenceReconstruction();

    @Test
    public void test1() {
//      org: [1,2,3], seqs: [[1,2],[1,3]]
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(1, 2));
        seqs.add(Arrays.asList(1, 3));

        assertThat(test.sequenceReconstruction(org, seqs)).isFalse();
    }

    @Test
    public void test2() {
//      org: [1,2,3], seqs: [[1,2]]
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(1, 2));

        assertThat(test.sequenceReconstruction(org, seqs)).isFalse();
    }

    @Test
    public void test3() {
//      org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(1, 2));
        seqs.add(Arrays.asList(1, 3));
        seqs.add(Arrays.asList(2, 3));

        assertThat(test.sequenceReconstruction(org, seqs)).isTrue();
    }

    @Test
    public void test4() {
//      org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
        int[] org = {4, 1, 5, 2, 6, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(5, 2, 6, 3));
        seqs.add(Arrays.asList(4, 1, 5, 2));

        assertThat(test.sequenceReconstruction(org, seqs)).isTrue();
    }
}
