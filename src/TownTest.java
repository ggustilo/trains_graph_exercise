import static org.junit.Assert.*;
import org.junit.Test;

public class TownTest {

    private Town town = new Town("A");

  @Test
  public void townShouldHaveNameString() {
    // assert statement
    assertSame("Town A should have name 'A'", "A", town.getName());
  }

  @Test
  public void townShouldHaveTracksOutArray() {
    // assert statement
   assertSame("Town A should have an array of tracks going out of town", Main.getGraph().findAllTracksOutOfTown(town), town.getTracksOut());
  }

  @Test
  public void townShouldHaveTracksInArray() {
    // assert statement
    assertSame("Town A should have an array of tracks going into town", Main.getGraph().findAllTracksIntoTown(town), town.getTracksIn());
  }

}
