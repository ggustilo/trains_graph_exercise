import static org.junit.Assert.*;
import org.junit.Test;

public class TownTest {

  private Town testTown = new Town("A");

  @Test
  public void townShouldHaveNameString() {
    // assert statement
    assertEquals("Town A should have name 'A'", "A", testTown.getName());
  }

  @Test
  public void townShouldHaveTracksOutArray() {
    // assert statement
    assertEquals("Town A should have an array of tracks going out of town", testTown.findAllTracksOut(), testTown.getTracksOut());
  }

  @Test
  public void townShouldHaveTracksInArray() {
    // assert statement
    assertEquals("Town A should have an array of tracks going into town", testTown.findAllTracksIn(), testTown.getTracksIn());
  }

}
