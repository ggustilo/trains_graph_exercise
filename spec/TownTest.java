package spec;

   
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.hamcrest.*;
import src.*;

public class TownTest {

  @Test
  public void townShouldHaveNameString() {
    // assert statement
    assertSame("Town A should have name 'A'", "A", Fixtures.townA.getName());
  }

  @Test
  public void townShouldHaveTracksOutArray() {
    // assert statement
   assertArrayEquals("Town A should have an array of tracks going out of town", Fixtures.tracksOutForTownA, Fixtures.townA.getTracksOut(Fixtures.graph));
  }

  @Test
  public void townShouldHaveTracksInArray() {
    // assert statement
    assertArrayEquals("Town A should have an array of tracks going into town", Fixtures.tracksInForTownA, Fixtures.townA.getTracksIn(Fixtures.graph));
  }

}
