package spec;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.hamcrest.*;

import src.*;

public class RouteTest {

  @Test
  public void routeShouldHaveTownsAlongWhichItPasses() {
    // assert statement
    assertArrayEquals("A route should have towns along which it passes", Fixtures.towns, Fixtures.testRoute.getTowns());
  }

  @Test
  public void aValidRouteShouldHaveTracksBetweenItsTowns() {
    // assert statement
    assertSame("A valid route should have tracks between its towns", Fixtures.routeTracks, Fixtures.testRoute.findTracks());
  }

  // @Test
  // public void anInvalidRouteShouldNotHaveTracksBetweenItsTowns() {
  //   Track[] emptyArrayOfTracks = new Track[0];
  //   // assert statement
  //   assertSame("An invalid route should not have tracks between its towns", Fixtures.emptyArrayOfTracks, Fixtures.testRoute.findTracks());
  // }

  // @Test
  // public void routeShouldHaveATotalDistance() {
  //   // assert statement
  //   assertSame("A route should have a total distance", 9, Fixtures.testRoute.findTotalDistance());
  // }

}
