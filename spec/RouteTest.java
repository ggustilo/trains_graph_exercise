package spec;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class RouteTest {

  @Test
  public void routeShouldHaveTownsAlongWhichItPasses() {
    // assert statement
    assertArrayEquals("A route should have towns along which it passes", towns, testRoute.getTowns());
  }

  @Test
  public void aValidRouteShouldHaveTracksBetweenItsTowns() {
    // assert statement
    assertSame("A valid route should have tracks between its towns", routeTracks, testRoute.findTracks());
  }

  @Test
  public void anInvalidRouteShouldNotHaveTracksBetweenItsTowns() {
    Track[] emptyArrayOfTracks = new Track[0];
    // assert statement
    assertSame("An invalid route should not have tracks between its towns", emptyArrayOfTracks, testRoute.findTracks());
  }

  @Test
  public void routeShouldHaveATotalDistance() {
    // assert statement
    assertSame("A route should have a total distance", 9, testRoute.findTotalDistance());
  }

}
