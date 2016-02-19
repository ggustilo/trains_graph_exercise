package spec;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.hamcrest.*;

import src.*;

public class GraphTest {

    @Test
    public void graphShouldHaveAnArrayOfTowns() {
        assertArrayEquals("A graph should have an array of town objects.", Fixtures.towns, Fixtures.graph.getTowns());
    }

    @Test
    public void graphShouldHaveAnArrayOfTracks() {
        assertArrayEquals("A graph should have an array of track objects.", Fixtures.tracks, Fixtures.graph.getTracks());
    }

    @Test
    public void graphShouldBeAbleToGetATownByName() {
    	 assertSame("A graph should be able to get a town by its name.", Fixtures.townA, Fixtures.graph.getTown("A"));	
    }

    @Test
    public void graphShouldBeAbleToFindAllTracksOutOfATown() {
    	 assertEquals("A graph should be able to find all tracks out of a town.", Fixtures.tracksOutForTownA, Fixtures.graph.findAllTracksOutOfTown(Fixtures.townA));	
    }

    @Test
    public void graphShouldBeAbleToFindAllTracksIntoATown() {
    	 assertEquals("A graph should be able to find all tracks into a town.", Fixtures.tracksInForTownC, Fixtures.graph.findAllTracksIntoTown(Fixtures.townC));	
    }

    @Test
    public void graphShouldBeAbleToFindATrackBetweenTwoTowns() {
    	 assertSame("A graph should be able to find a track between two towns if it exists.", Fixtures.trackAB, Fixtures.graph.findDirectedTrackBetweenTwoTowns(Fixtures.townA, Fixtures.townB));	
    }

   @Test
    public void graphShouldNotBeAbleToFindATrackBetweenTwoTownsIfItDoesntExist() {
    	 assertSame("A graph should NOT be able to find a track between two towns if it doesn't exist.", null, Fixtures.graph.findDirectedTrackBetweenTwoTowns(Fixtures.townD, Fixtures.townC));	
    }

    @Test
    public void graphShouldBeAbleToFindTotalDistanceOfARoute() {
    	 assertSame("A graph should be able to find the total distance of a route.", 25, Fixtures.graph.findTotalDistanceOfRoute(Fixtures.testRoute));	
    }

    @Test
    public void graphShouldBeAbleToGetAllNeighboringTownsForATown() {
    	 assertEquals("A graph should be able to get all neighboring towns for a town.", Fixtures.adjacentTowns, Fixtures.graph.getAllNeighboringTowns(Fixtures.townA));	
    }

    @Test
    public void graphShouldBeAbleToFindAllRoutesWithMaxStops() {
    	 assertEquals("A graph should be able to find all routes given origin, destination, and max stops.", Fixtures.routesForCC3, Fixtures.graph.findRoutesWithMaxStops(Fixtures.townC, Fixtures.townC, 3));	
    }

    @Test
    public void graphShouldBeAbleToFindAllRoutesWithExactStops() {
    	 assertEquals("A graph should be able to find all routes given origin, destination, and exact stops.", Fixtures.routesForAC4, Fixtures.graph.findRoutesWithMaxStops(Fixtures.townA, Fixtures.townC, 4));	
    }
}
