package src;

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

    // public List<Track> findTracks() {
    //     List<Track> tracks = new ArrayList<Track>();

    //     for(int i = 0; i < towns.length; i++)
    //     {
    //         Track directedTrack = graph.findDirectedTrackBetweenTwoTowns(towns[i], towns[i + 1]);

    //         if (!tracks.contains(directedTrack)) {
    //             tracks.add(directedTrack);
    //         }
    //     }
    //     return tracks;
    // }

	// public method to calculate total distance of path given array of towns

    public int findTotalDistance(Town[] towns) {
        /*
        input: an array of towns

        initialize array of tracks
        for length of towns - 1
        iterate through array of towns
        get towns[i] and towns[i + 1]
        call graph.findDirectedTrackBetweenTwoTowns(towns[i], towns[i + 1])
        add found tracks to array of tracks

        check that the length of tracks is length of towns - 1
        if true,
            initialize int totalDistance
            iterate through tracks and get distance
            add distance to totalDistance
            return totalDistance
        if false
            return "NO SUCH ROUTE"
        */
    }

    // public method to calculate a route

    public int findRoute(Town origin, Town destination, int numStops) {
        /*
        input: a start town, an end town, number of stops
        
        initialize int numStopsTried
        initialize array of towns townsOnRoute

        recursive --- 
        call graph.findAllTracksOutOfTown on origin
        iterate through returned array of tracks
            get destination for each track
            if one of the tracks has the destination town
                add one to numStopsTried
                add name of destination town to townsOnRoute
                return townsOnRoute
            else if numStopsTried is greater than numStops
                return 'No such route within allowed number of stops!"
            else for each of the tracks
                set destination of track to new origin
                add one to numStopsTried
                call graph.findAllTracksOutOfTown on origin
        recursive ---

        */
    }

    // public method to calculate the number of routes possible given start, end and # stops

    public int findNumberRoutes(Town origin, Town destination, int numStops) {
        /*
        input: a start town, an end town, number of stops
        
        initialize num Routes
        call graph.findAllTracksOutOfTown on origin
        iterate through returned array of tracks
            if one of the tracks is the destination town
                add one to numStops
                return

        */
    }

    // public method to calculate the number of routes possible given max number of stops

    // public method to calculate length of shortest route given start and end

    // public method to calculate number of different routes possible given start and end and total distance
}