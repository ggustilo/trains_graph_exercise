import java.util.ArrayList;
import java.util.List;

public class Town {

    private String name;

    public Town(String townName) {
        this.name = townName;
    }

    public static void main(String[] args) {

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


    public Track[] getTracksOut() {
        List<Track> tracksOutOfTown = Main.getGraph().findAllTracksOutOfTown(this);
        Track[] tracks = new Track[tracksOutOfTown.size()];
        tracksOutOfTown.toArray(tracks);
        return tracks;
    }

    public Track[] getTracksIn() {
        List<Track> tracksIntoTown = Main.getGraph().findAllTracksIntoTown(this);
        Track[] tracks = new Track[tracksIntoTown.size()];
        tracksIntoTown.toArray(tracks);
        return tracks;
    }

 }