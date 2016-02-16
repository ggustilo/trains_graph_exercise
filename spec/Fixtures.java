package spec;
import src.*;
import junit.framework.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;


public class Fixtures extends TestSuite {

    public static Town townA;
    public static Town townB;
    public static Town townC;
    public static Town[] towns = new Town[3];

    public static Track trackAB;
    public static Track trackBC;
    public static Track trackCA;
    public static Track trackBA;
    public static Track trackCB;
    public static Track trackAC;
    public static Track[] tracks = new Track[6];

    public static Graph graph;
    public static Route testRoute;
    public static Track[] routeTracks;
    public static Track[] tracksOutForTownA;
    public static Track[] tracksInForTownA;

    @BeforeClass
    public static void setUp() {
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
    public static void tearDown() {
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
        tracksOutForTownA = null;
        tracksInForTownA = null;
    }
}
