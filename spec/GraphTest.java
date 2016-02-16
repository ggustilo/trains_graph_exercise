package spec;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTest {

    @Test
    public void graphShouldHaveAnArrayOfTowns() {
        assertArrayEquals("A graph should have an array of town objects.", towns, graph.getTowns());
    }

    @Test
    public void graphShouldHaveAnArrayOfTracks() {
        assertArrayEquals("A graph should have an array of track objects.", tracks, graph.getTracks());
    }

}
