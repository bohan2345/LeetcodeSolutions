package backtrack;

import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ReconstructItineraryTest {
    @Test
    public void test() {
        ReconstructItinerary test = new ReconstructItinerary();
        String[][] tickets = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};

        List<String> actual = test.findItinerary(tickets);

        assertThat(actual).containsExactly("JFK", "ATL", "JFK", "SFO", "ATL", "SFO").inOrder();
    }
}
