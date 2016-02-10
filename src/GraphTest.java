import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTest {
    private Town town1 = new Town("A");
    private Town town2 = new Town("B");
    private Town town3 = new Town("C");

    private Town[] testTowns = {town1, town2, town3};

    private Track trackAB = new Track(town1, town2, 5);
    private Track trackBC = new Track(town2, town3, 7);
    private Track trackCB = new Track(town3, town2, 8);

    private Track[] testTracks = {trackAB, trackBC, trackCB};

    private Graph testGraph = new Graph(testTowns, testTracks);

    @Test
    public void graphShouldHaveAnArrayOfTowns() {
        assertArrayEquals("A graph should have an array of town objects.", testTowns, testGraph.getTowns());
    }

    @Test
    public void graphShouldHaveAnArrayOfTracks() {
        assertArrayEquals("A graph should have an array of track objects.", testTracks, testGraph.getTracks());
    }

}
