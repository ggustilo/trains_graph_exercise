import static org.junit.Assert.*;
import org.junit.Test;

public class TrackTest {
  private Town startTown = new Town("A");
  private Town endTown = new Town("B");
  private Track testTrack = new Track(startTown, endTown, 5);

  @Test
  public void trackShouldHaveAStartTown() {
    // assert statement
    assertSame("Track should have a start point that is a town.", startTown, testTrack.getOrigin());
  }

  @Test
  public void trackShouldHaveAnEndTown() {
    // assert statement
    assertSame("Track should have an end point that is a town.", endTown, testTrack.getDestination());
  }

  @Test
  public void TrackShouldHaveADistance() {
    // assert statement
    assertSame("Track should have a distance that is an integer.", 5, testTrack.getDistance());
  }

}
