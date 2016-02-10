import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class Graph {

    private Town[] towns;
    private Track[] tracks;

    public Graph(Town[]vertices, Track[]edges) {
        this.towns = vertices;
        this.tracks = edges;
    }

    public Town[] getTowns() {
        return towns;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public List<Track> findAllTracksOutOfTown(Town town) {
        List<Track> tracksOut = new ArrayList<Track>();
        Track[] allTracks = this.getTracks();

        for (int i = 0; i < allTracks.length; i++) {
            if (allTracks[i].getOrigin() == town) {
                tracksOut.add(allTracks[i]);
            }
        }
        return tracksOut;
    }

    public List<Track> findAllTracksIntoTown(Town town) {
        List<Track> tracksIn = new ArrayList<Track>();
        Track [] allTracks = this.getTracks();

        for (int i = 0; i < allTracks.length; i++) {
            if (allTracks[i].getDestination() == town) {
                tracksIn.add(allTracks[i]);
            }
        }
        return tracksIn;
    }
}
