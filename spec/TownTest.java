package spec;

   
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import src.*;

public class TownTest {

  @Test
  public void townShouldHaveNameString() {
    // assert statement
    assertSame("Town A should have name 'A'", "A", townA.getName());
  }

  @Test
  public void townShouldHaveTracksOutArray() {
    // assert statement
      System.out.println(tracksOutForTown1);
      System.out.println(town1.getTracksOut(graph));
   assertArrayEquals("Town A should have an array of tracks going out of town", Fixtures.tracksOutForTown1, Fixtures.town1.getTracksOut(graph));
  }

  @Test
  public void townShouldHaveTracksInArray() {
    // assert statement
    assertArrayEquals("Town A should have an array of tracks going into town", Fixtures.tracksInForTown1, Fixtures.town1.getTracksIn(graph));
  }

}
