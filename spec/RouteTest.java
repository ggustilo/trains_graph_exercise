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
    assertArrayEquals("A route should have towns along which it passes", Fixtures.townsForTestRoute, Fixtures.testRoute.getTowns());
  }

  @Test
  public void aValidRouteShouldHaveTracksBetweenItsTowns() {
    // assert statement
    assertSame("A valid route should have tracks between its towns", Fixtures.routeTracks, Fixtures.testRoute.findTracks());
  }

  @Test
  public void anInvalidRouteShouldNotHaveTracksBetweenItsTowns() {
    Track[] emptyArrayOfTracks = new Track[0];
    // assert statement
    assertSame("An invalid route should not have tracks between its towns", emptyArrayOfTracks, Fixtures.testRoute.findTracks());
  }

}
