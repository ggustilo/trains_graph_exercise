import static org.junit.Assert.*;
import org.junit.Test;

public class TownTest {

    private Town town1 = new Town("A");
    private Town town2 = new Town("B");
    private Town town3 = new Town("C");
    private Town[] towns = {town1, town2, town3};

    private Track track1 = new Track(town1, town2, 3);
    private Track track2 = new Track(town2, town3, 4);
    private Track track3 = new Track(town3, town1, 5);
    private Track track4 = new Track(town2, town1, 6);
    private Track track5 = new Track(town3, town2, 7);
    private Track track6 = new Track(town1, town3, 9);
    private Track[] tracks = {track1, track2, track3, track4, track5, track6};

    private Graph graph = new Graph(towns, tracks);

    private Track[] tracksOutForTown1 = {track1, track6};
    private Track[] tracksInForTown1 = {track3, track4};

  @Test
  public void townShouldHaveNameString() {
    // assert statement
    assertSame("Town A should have name 'A'", "A", town1.getName());
  }

  @Test
  public void townShouldHaveTracksOutArray() {
    // assert statement
      System.out.println(tracksOutForTown1);
      System.out.println(town1.getTracksOut(graph));
   assertArrayEquals("Town A should have an array of tracks going out of town", tracksOutForTown1, town1.getTracksOut(graph));
  }

  @Test
  public void townShouldHaveTracksInArray() {
    // assert statement
    assertArrayEquals("Town A should have an array of tracks going into town", tracksInForTown1, town1.getTracksIn(graph));
  }

}
