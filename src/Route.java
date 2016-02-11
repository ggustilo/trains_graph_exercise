import java.util.ArrayList;
import java.util.List;

public class Route {

    private Town[] towns;

    public Route(Town[] townsOnRoute) {
        this.towns = townsOnRoute;
    }

	public static void main(String[] args) {

	}

    public Town[] getTowns() {

        return this.towns;
    }

    public List<Track> findTracks() {
        Main main = new Main();
        Graph graph = main.getGraph();
        List<Track> tracks = new ArrayList<Track>();

        for(int i = 0; i < towns.length; i++)
        {
            Track directedTrack = graph.findDirectedTrackBetweenTwoTowns(towns[i], towns[i + 1]);

            if (!tracks.contains(directedTrack)) {
                tracks.add(directedTrack);
            }
        }
        return tracks;
    }

	// public method to calculate total distance of path given array of towns

    public int findTotalDistance() {

        return 9;
    }

	// public method to calculate the number of routes possible given start, end and # stops

	// public method to calculate the number of routes possible given max number of stops

	// public method to calculate length of shortest route given start and end

	// public method to calculate number of different routes possible given start and end and total distance
}