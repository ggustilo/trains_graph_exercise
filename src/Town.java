import java.util.ArrayList;
import java.util.List;

public class Town {

    private String name;
    private List<Track> tracksIn;
    private List<Track> tracksOut;

    public Town(String townName) {
        this.name = townName;
		this.tracksOut = findAllTracksOut();
        this.tracksIn = findAllTracksIn();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Town town = (Town) o;

        return getName().equals(town.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    public String getName() {
        return this.name;
    }

    public List<Track> getTracksOut() {
        return this.tracksOut;
    }

    public List<Track> getTracksIn() {
        return this.tracksIn;
    }

    public List<Track> findAllTracksOut() {
        List<Track> tracks = new ArrayList<Track>();

        return tracks;
    }

    public List<Track> findAllTracksIn() {
        List<Track> tracks = new ArrayList<Track>();
        return tracks;
    }
 }