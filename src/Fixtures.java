import junit.framework.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Fixtures extends TestSuite {

    public Town townA;
    public Town townB;
    public Town townC;
    public Town[] towns = new Town[3];

    public Track trackAB;
    public Track trackBC;
    public Track trackCA;
    public Track trackBA;
    public Track trackCB;
    public Track trackAC;
    public Track[] tracks = new Track[6];

    public Graph graph;
    public Route testRoute;
    public Track[] routeTracks;
    public Track[] tracksOutForTown1;
    public Track[] tracksInForTown1;

    @BeforeClass
    protected void setUp() {
        townA = new Town("A");
        townB = new Town("B");
        townC = new Town("C");

        Town[] towns = {townA, townB, townC};

        trackAB = new Track(townA, townB, 5);
        trackBC = new Track(townB, townC, 4);
        trackCA = new Track(townC, townA, 5);
        trackBA = new Track(townB, townA, 6);
        trackCB = new Track(townC, townB, 7);
        trackAC = new Track(townA, townC, 9);

        Track[] tracks = {trackAB, trackBC, trackCA, trackBA, trackCB, trackAC};

        graph = new Graph(towns, tracks);

        testRoute = new Route(towns);

        Track[] routeTracks = {trackAB, trackBC};
        Track[] tracksOutForTown1 = {trackAB, trackAC};
        Track[] tracksInForTown1 = {trackCA, trackBA};

    }

    @AfterClass
    protected void tearDown() {
        townA = null;
        townB = null;
        townC = null;
        towns = null;
        trackAB = null;
        trackBC = null;
        trackCA = null;
        trackBA = null;
        trackCB = null;
        trackAC = null;
        tracks = null;
        graph = null;
        testRoute = null;
        routeTracks = null;
        tracksOutForTown1 = null;
        tracksInForTown1 = null;
    }
}
