package src;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
            if (allTracks[i].getOrigin().equals(town)) {
                tracksOut.add(allTracks[i]);
            }
        }
        return tracksOut;
    }

    public List<Track> findAllTracksIntoTown(Town town) {
        List<Track> tracksIn = new ArrayList<Track>();
        Track [] allTracks = this.getTracks();

        for (int i = 0; i < allTracks.length; i++) {
            if (allTracks[i].getDestination().equals(town)) {
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
        //FIXME: Should be able to return null - class wrapper for object?
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

    public Iterable<Town> getAllNeighboringTowns(Town town) {
        List<Track> tracks = this.findAllTracksOutOfTown(town);
        List<Town> neighboringTowns = new ArrayList<Town>();
        for (Track track : tracks) {
            neighboringTowns.add(track.getDestination());
        }
        if (neighboringTowns == null) {
            return Collections.emptyList();
        }
        else {
            return neighboringTowns;
        }
    }

    public void displayRoutes(List<Route> routes) {
        System.out.println("======Number of Routes:  " + routes.size() + "\n");
        for (Route route : routes) {
            System.out.println("Route object id: " + route + "\n");
            System.out.println("Route origin: " + route.getTowns()[0].getName()+ "\n");
            System.out.println("Route destination: " + route.getTowns()[route.getTowns().length-1].getName()+ "\n");
            System.out.println("Number of towns in route: " + route.getTowns().length + "\n");
            System.out.print("Route by towns: \n\n");
            for (Town town : route.getTowns()) {
                System.out.print(town.getName() + "  ");
            }
            System.out.print("\n\n==================\n\n");
        }
    }

    public List<Route> findRoutesWithMaxStops(Town origin, Town destination, int maxNumStopsAllowed) {
        DepthFirstSearcher searcher = new DepthFirstSearcher();
        List<Route> routes = new ArrayList<Route>();
        int counter = 0;
        searcher.setUp(this, origin, destination);
        do {
            do {
                searcher.next();
                counter += 1;
            } while (counter < maxNumStopsAllowed);
            routes = searcher.getRoutes();
        } while (searcher.next().getName() != "Null");
        this.displayRoutes(routes);
        return routes;
    }

    public List<Route> findRoutesWithExactStops(Town origin, Town destination, int exactNumStopsNeeded) {
        List<Town> towns = new ArrayList<Town>();
        BreadthFirstSearcher searcher = new BreadthFirstSearcher();
        List<Route> routes = new ArrayList<Route>();
        int counter = 0;
        searcher.setUp(this, origin, destination, exactNumStopsNeeded);
        do {
            do {
                towns.add(searcher.next());
            } while (counter < exactNumStopsNeeded);
            
            if (towns.get(towns.size() - 1).equals(destination)) {
                Town[] routeTowns = new Town[towns.size()];
                towns.toArray(routeTowns);
                Route route = new Route(routeTowns);
                routes.add(route);
            }
            counter += 1;
        } while (searcher.next().getName() != "Null");

        this.displayRoutes(routes);
        return routes;
    }



}
