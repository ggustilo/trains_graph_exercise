package spec;
import src.*;
import junit.framework.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.*;


public class Fixtures extends TestSuite {

    public static Town townA;
    public static Town townB;
    public static Town townC;
    public static Town townD;
    public static Town townE;
    public static Town[] towns = new Town[5];
    public static Town[] townsForTestRoute = new Town[5];
    public static List<Town> adjacentTowns = new ArrayList<Town>();
    public static Iterable<Town> neighborTowns = adjacentTowns;
    public static Town[] townsForRouteCDC = new Town[3];
    public static Town[] townsForRouteCEBC = new Town[4];
    public static Town[] townsForRouteABCDC = new Town[5];
    public static Town[] townsForRouteADCDC = new Town[5];
    public static Town[] townsForRouteADEBC = new Town[5];

    public static Track trackAB;
    public static Track trackBC;
    public static Track trackCD;
    public static Track trackDC;
    public static Track trackDE;
    public static Track trackAD;
    public static Track trackCE;
    public static Track trackEB;
    public static Track trackAE;
    public static Track[] tracks = new Track[9];

    public static Graph graph;
    public static Route testRoute;
    public static Route routeCDC;
    public static Route routeCEBC;
    public static Route routeABCDC;
    public static Route routeADCDC;
    public static Route routeADEBC;
    public static Track[] routeTracks;
    public static Track[] tracksOutForTownA;
    public static Track[] tracksInForTownC;
    public static List<Route> routesForCC3 = new ArrayList<Route>();
    public static List<Route> routesForAC4 = new ArrayList<Route>();

    @BeforeClass
    public static void setUp() {
        townA = new Town("A");
        townB = new Town("B");
        townC = new Town("C");
        townD = new Town("D");
        townE = new Town("E");

        Town[] towns = {townA, townB, townC, townD, townE};
        Town[] townsForTestRoute = {townA, townB, townC, townD, townC};
        adjacentTowns.add(townB);
        adjacentTowns.add(townD);
        adjacentTowns.add(townE);
        Iterable<Town> neighborTowns = adjacentTowns;
        Town[] townsForRouteCDC = {townC, townD, townC};
        Town[] townsForRouteCEBC = {townC, townE, townB, townC};

        trackAB = new Track(townA, townB, 5);
        trackBC = new Track(townB, townC, 4);
        trackCD = new Track(townC, townD, 8);
        trackDC = new Track(townD, townC, 8);
        trackDE = new Track(townD, townE, 6);
        trackAD = new Track(townA, townD, 5);
        trackCE = new Track(townC, townE, 2);
        trackEB = new Track(townE, townB, 3);
        trackAE = new Track(townA, townE, 7);

        Track[] tracks = {trackAB, trackBC, trackCD, trackDC, trackDE, trackAD, trackCE, trackEB, trackAE};

        graph = new Graph(towns, tracks);

        testRoute = new Route(townsForTestRoute);
        routeCDC = new Route(townsForRouteCDC);
        routeCEBC = new Route(townsForRouteCEBC);
        routeABCDC = new Route(townsForRouteABCDC);
        routeADCDC = new Route(townsForRouteADCDC);
        routeADEBC = new Route(townsForRouteADEBC);

        routesForCC3.add(routeCDC);
        routesForCC3.add(routeCEBC);
        routesForAC4.add(routeABCDC);
        routesForAC4.add(routeADCDC);
        routesForAC4.add(routeADEBC);

        Track[] routeTracks = {trackAB, trackBC, trackCD, trackDC};
        Track[] tracksOutForTownA = {trackAB, trackAD, trackAE};
        Track[] tracksInForTownC = {trackBC, trackDC};
    }

    @AfterClass
    public static void tearDown() {
        townA = null;
        townB = null;
        townC = null;
        townD = null;
        townE = null;
        towns = null; 
        townsForTestRoute = null;
        neighborTowns = null;
        adjacentTowns = null;
        townsForRouteCDC   = null;
        townsForRouteCEBC  = null;
        townsForRouteABCDC = null;
        townsForRouteADCDC = null;
        townsForRouteADEBC = null;
        trackAB = null;
        trackBC = null;
        trackCD = null;
        trackDC = null;
        trackDE = null;
        trackAD = null;
        trackCE = null;
        trackEB = null;
        trackAE = null;
        tracks = null;
        graph = null;
        testRoute = null;
        routeCDC = null;
        routeCEBC = null;
        routeABCDC = null;
        routeADCDC = null;
        routeADEBC = null;
        routeTracks = null;
        tracksOutForTownA = null;
        tracksInForTownC = null;
        routesForCC3 = null;
        routesForAC4 = null;
    }
}
