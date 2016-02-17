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

    public void displayRoutes(List<Route> routes) {
        System.out.println("======Number of Routes:  " + routes.size() + "\n");
        for (Route route : routes) {
            System.out.println("Route object id: " + route + "\n");
            System.out.println("Route origin: " + route.getTowns()[0].getName()+ "\n");
            System.out.println("Route destination: " + route.getTowns()[route.getTowns().length-1].getName()+ "\n");
            System.out.println("Number of towns in route: " + route.getTowns().length + "\n");
            System.out.print("Route by towns: \n");
            for (Town town : route.getTowns()) {
                System.out.print(town.getName() + "  ");
            }
            System.out.print("\n\n==================\n\n");
        }
    }

    public List<Route> findRoutesWithMaxStops(Town origin, Town destination, int maxNumStopsAllowed) {
        List<Town> townsVisited = new ArrayList<Town>();
        List<Route> routes = new ArrayList<Route>();
        routes.addAll(this.depthFirstSearchWithMaxStops(origin, destination, maxNumStopsAllowed, townsVisited, routes));
        this.displayRoutes(routes);
        return routes;
    }


    public List<Route> depthFirstSearchWithMaxStops(Town origin, Town destination, int maxNumStopsAllowed, List<Town> townsVisited, List<Route> routes) {
        int numStopsTried = townsVisited.size();
        townsVisited.add(origin);
        List<Track> tracksFromOrigin = this.findAllTracksOutOfTown(origin);

            System.out.println("\nNew call...\n");
            System.out.println("Origin:" + origin.getName() + "\n");
            for (Track track : tracksFromOrigin) {
                System.out.print("Returned tracks:" + track.getDestination().getName() + ", ");
            }
            System.out.println("\n Number of Stops tried so far:" + numStopsTried);

        for (Track track : tracksFromOrigin) {
            Town nextTown = track.getDestination();

                System.out.println("This is the next town:" + nextTown.getName());
                System.out.println("Is Destination?:" + nextTown.equals(destination));

            if (nextTown.equals(destination)) {
                numStopsTried += 1;
                townsVisited.add(nextTown);

                    System.out.println("Number of stops when we have a route:" + numStopsTried);

                Town[] routeTowns = new Town[townsVisited.size()];
                townsVisited.toArray(routeTowns);
                routes.add(new Route(routeTowns));

                    System.out.println("Towns visited so far in Route: ");
                    for (Town town : townsVisited) {
                        System.out.print(town.getName() + "  ");
                    }
                    System.out.println("\n**************\nGotta Route!\n");
                    System.out.println("Num routes:" + routes.size());

                numStopsTried = 0;
                Town originalOrigin = townsVisited.get(0);
                townsVisited.removeAll(townsVisited);
                townsVisited.add(originalOrigin);
                return routes;
            }
            else if (numStopsTried > maxNumStopsAllowed) {
                    System.out.println("There were no routes that fulfilled the requested paramenters.");
                return routes;
            }
            else {
                    System.out.println("Try again with new origin of: "+ nextTown.getName());
                    System.out.println("Towns visited so far are: ");
                    for (Town town : townsVisited) {
                        System.out.print(town.getName() + "  ");
                    }

                numStopsTried += 1;
                this.depthFirstSearchWithMaxStops(nextTown, destination, maxNumStopsAllowed, townsVisited, routes);
            }
        }
        List<Route> emptyRoutes = new ArrayList<Route>();
        return emptyRoutes;
    }

    public List<Route> findRoutesWithExactStops(Town origin, Town destination, int numStopsNeeded) {
        List<Town> townsVisited = new ArrayList<Town>();
        List<Route> routes = new ArrayList<Route>();
        routes.addAll(this.depthFirstSearchWithExactStops(origin, destination, numStopsNeeded, townsVisited, routes));
        this.displayRoutes(routes);
        return routes;
    }

    public List<Route> depthFirstSearchWithExactStops(Town origin, Town destination, int numStopsNeeded, List<Town> townsVisited, List<Route> routes) {
        List<Route> emptyRoutes = new ArrayList<Route>();
        int numStopsTried = townsVisited.size();
        List<Track> tracksFromOrigin = this.findAllTracksOutOfTown(origin);
        
        townsVisited.add(origin);

            System.out.println("\nNew call...\n");
            System.out.println("Origin:" + origin.getName() + "\n");
            for (Track track : tracksFromOrigin) {
                System.out.print("Returned tracks:" + track.getDestination().getName() + ", ");
            }
            System.out.println("\n Number of Stops tried so far:" + numStopsTried);

        for (Track track : tracksFromOrigin) {
            Town nextTown = track.getDestination();

                System.out.println("This is the next town:" + nextTown.getName());
                System.out.println("Is Destination?:" + (nextTown.equals(destination) && numStopsTried == numStopsNeeded));
            
            if (nextTown.equals(destination) && numStopsTried + 1 == numStopsNeeded) {
                townsVisited.add(nextTown);

                    System.out.println("Number of stops when we have a route:" + numStopsTried);

                Town[] routeTowns = new Town[townsVisited.size()];
                townsVisited.toArray(routeTowns);
                routes.add(new Route(routeTowns));

                    System.out.println("Towns visited so far in Route: ");
                    for (Town town : townsVisited) {
                        System.out.print(town.getName() + "  ");
                    }
                    System.out.println("\n**************\nGotta Route!\n");
                    System.out.println("Num routes:" + routes.size());

                Town originalOrigin = townsVisited.get(0);
                townsVisited.removeAll(townsVisited);
                townsVisited.add(originalOrigin);
                return routes;
            }
            else {
                    System.out.println("Try again with new origin of: "+ nextTown.getName());
                    System.out.println("Towns visited so far are: ");
                    for (Town town : townsVisited) {
                        System.out.print(town.getName() + "  ");
                    }
                if (townsVisited.size() > numStopsNeeded) {
                    continue;
                }
                this.depthFirstSearchWithExactStops(nextTown, destination, numStopsNeeded, townsVisited, routes);
            }
        }
        return emptyRoutes;
    }

    public int findNumberRoutes(Town origin, Town destination, int numStops) {
        /*
        input: a start town, an end town, number of stops
        
        numStops times DO:
            find all tracks out of origin
            if one track has destination town of destination
                add to array of towns
                create route from array of towns
                add route to array of valid routes
            else
                set each destination town as new origin
                call find all tracks
            end

        */
        return 9;
    }

    // public method to calculate the number of routes possible given max number of stops

    // public method to calculate length of shortest route given start and end

    // public method to calculate number of different routes possible given start and end and total distance
}
