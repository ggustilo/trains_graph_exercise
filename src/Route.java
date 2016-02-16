package src;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private Town[] towns;
    private List<Track> tracks;

    public Route(Town[] townsOnRoute) {
        this.towns = townsOnRoute;
        this.tracks = findTracks();
    }

	public static void main(String[] args) {

	}

    public Town[] getTowns() {
        return this.towns;
    }

    public Track[] getTracks() {
        Track[] routeTracks = new Track[this.tracks.size()];
        this.tracks.toArray(routeTracks);
        return routeTracks;
    }

    public List<Track> findTracks() {
        List<Track> tracks = new ArrayList<Track>();
        
        for (int i = 0; i < towns.length - 1; i++) {
            Track directedTrack = Main.graph.findDirectedTrackBetweenTwoTowns(towns[i], towns[i + 1]);
            if (!(directedTrack == null) && (!tracks.contains(directedTrack))) {

                tracks.add(directedTrack);
            }
        }
        return tracks;
    }

}