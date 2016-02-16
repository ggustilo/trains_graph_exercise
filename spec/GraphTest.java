package spec;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import src.*;

public class GraphTest {

    @Test
    public void graphShouldHaveAnArrayOfTowns() {
        assertArrayEquals("A graph should have an array of town objects.", Fixtures.towns, graph.getTowns());
    }

    @Test
    public void graphShouldHaveAnArrayOfTracks() {
        assertArrayEquals("A graph should have an array of track objects.", Fixtures.tracks, graph.getTracks());
    }

}
