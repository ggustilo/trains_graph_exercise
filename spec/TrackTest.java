package spec;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import src.*;

public class TrackTest {

  @Test
  public void trackShouldHaveAStartTown() {
    // assert statement
    assertSame("Track should have a start point that is a town.", Fixtures.townA, Fixtures.trackAB.getOrigin());
  }

  @Test
  public void trackShouldHaveAnEndTown() {
    // assert statement
    assertSame("Track should have an end point that is a town.", Fixtures.townB, Fixtures.trackAB.getDestination());
  }

  @Test
  public void TrackShouldHaveADistance() {
    // assert statement
    assertSame("Track should have a distance that is an integer.", 5, Fixtures.trackAB.getDistance());
  }

}
