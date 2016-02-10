import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTest {
    Town town1 = new Town("A");
    Town town2 = new Town("B");
    Town town3 = new Town("C");

    Town[] testTowns = {town1, town2, town3};

    Track trackAB = new Track(town1, town2, 5);
    Track trackBC = new Track(town2, town3, 7);
    Track trackCB = new Track(town3, town2, 8);

    Track[] testTracks = {trackAB, trackBC, trackCB};

    Graph testGraph = new Graph(testTowns, testTracks);

    @Test
    public void graphShouldHaveAnArrayOfTowns() {
        assertArrayEquals("A graph should have an array of town objects.", testTowns, testGraph.getTowns());
    }

    @Test
    public void graphShouldHaveAnArrayOfTracks() {
        assertArrayEquals("A graph should have an array of track objects.", testTracks, testGraph.getTracks());
    }

}
