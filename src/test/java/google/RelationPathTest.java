package google;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

public class RelationPathTest {
    @Test
    public void testConstructGraph() {
        List<List<Character>> relation = new ArrayList<>();
        relation.add(ImmutableList.of('0', '1', 'F'));
        relation.add(ImmutableList.of('1', '2', 'F'));
        relation.add(ImmutableList.of('1', '3', 'E'));

        RelationPath test = new RelationPath();

        Map<Character, Map<Character, List<Character>>> graph = test.constructGraph(relation);

        assertThat(graph).hasSize(4);
        assertThat(graph.get('0')).containsKey('F');
        assertThat(graph.get('0').get('F')).containsExactly('1');
        assertThat(graph.get('1')).containsKey('F');
        assertThat(graph.get('1').get('F')).containsExactly('0', '2');
        assertThat(graph.get('1')).containsKey('E');
        assertThat(graph.get('1').get('E')).containsExactly('3');
    }

    @Test
    public void testRelationPath() {
        List<List<Character>> relation = new ArrayList<>();
        relation.add(ImmutableList.of('0', '1', 'F'));
        relation.add(ImmutableList.of('1', '2', 'F'));
        relation.add(ImmutableList.of('1', '3', 'E'));

        RelationPath test = new RelationPath();

        Map<Character, Map<Character, List<Character>>> graph = test.constructGraph(relation);

        String path = test.relationPath('0', '2', "FF", graph);
        assertThat(path).isEqualTo("012");
    }
}
