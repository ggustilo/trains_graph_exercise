import static org.junit.Assert.*;
import org.junit.Test;

public class RouteTest {

  private Town[] towns = {new Town("A"), new Town("B"), new Town("C")};
  private Route testRoute = new Route(towns);

  @Test
  public void routeShouldHaveTownsAlongWhichItPasses() {
    // assert statement
    assertEquals("A route should have towns along which it passes", towns, testRoute.getTowns());
  }

//  @Test
//  public void aValidRouteShouldHaveTracksBetweenItsTowns() {
//    // assert statement
//    List<Track> tracks = new ArrayList<Track>();
//
//    for(int i = 0; i < towns.length; i++)
//    {
//      tracks.append(towns[i].getTracksOut());
//    }
//
//    assertEquals("A valid route should have tracks between its towns", tracks, testRoute.getTracksOut());
//  }

//  @Test
//  public void anInvalidRouteShouldHaveTracksBetweenItsTowns() {
//    // assert statement
//    assertEquals("An invalid route should not have tracks between its towns", nil, testRoute.getTracksOut());
//  }

//  @Test
//  public void routeShouldHaveATotalDistance() {
//    // assert statement
//    assertEquals(testTown.findAllTracksIn(), testRoute.getTracksIn());
//  }

}
