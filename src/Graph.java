package src;

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

    public Town getTown(String name) {
        for (Town town : towns) {
            if (town.getName().equals(name)) {
                return town;
            }
        }
        return null;
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

    public Track findDirectedTrackBetweenTwoTowns(Town origin, Town destination) {
        Track[] allTracks = this.getTracks();
        try {
            for (int i = 0; i < allTracks.length; i++) {
                if (allTracks[i].getOrigin().equals(origin) && allTracks[i].getDestination().equals(destination)) {
                    return allTracks[i];
                }
            } 
        }
        catch (NullPointerException e) { 
            return null;
        }   
        return null;
        //FIXME: Should be able to return null - ask about class wrappers
    }

    public java.lang.Integer findTotalDistanceOfRoute(Route route) {
        Town[] towns = route.getTowns();
        Track[] tracks = route.getTracks();
        if (tracks.length == towns.length - 1)
        {
            int totalDistance = 0;
            for (Track t : tracks) {
                totalDistance += t.getDistance();
            }
            return totalDistance;
        }
        else {
            System.out.println("NO SUCH ROUTE");
            return null;
        }
    }

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
        return 9;
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
        return 9;
    }

    // public method to calculate the number of routes possible given max number of stops

    // public method to calculate length of shortest route given start and end

    // public method to calculate number of different routes possible given start and end and total distance
}
