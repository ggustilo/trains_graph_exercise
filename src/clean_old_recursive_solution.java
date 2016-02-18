    // /*
    // set origin
    // find all towns adjacent to origin
    // iterate through towns
    // if town is destination and has not been previously visited
    //     return
    // else
    //     set town as origin
    //     call again
    // end

    // we also need to record the following:
    //     - town objects we have gone through (until we return - then clear out towns except for origin)
    //     - number of towns we have gone through
    //     - towns we have already visited

    // maybe sort the towns initially?
    // */

    // public List<Route> depthFirstSearchWithExactStops(Town origin, Town destination, int numStopsNeeded, List<Town> townsVisited, List<Route> routes) {
    //     // add the current origin to towns visited
    //     townsVisited.add(origin);
    //     // set up fall back routes
    //     List<Route> emptyRoutes = new ArrayList<Route>();
    //     // the number of stops made is equal to number of townsVisited 
    //     int numStopsTried = townsVisited.size()-1;
    //     // get outgoing tracks from town so we can find our next origin
    //     List<Track> tracksFromOrigin = this.findAllTracksOutOfTown(origin);

    //     for (int i = 0; i < tracksFromOrigin.size() - 1; i++) {
    //     // iterate through all the tracks going out from our town
    //         Town nextTown = tracksFromOrigin.get(i).getDestination();
    //         // set the next origin equal to the destination for track i

    //         // if that next origin is our destination and we have exactly the right number of stops
    //             // then add the town to our visted list
    //         if (nextTown.equals(destination) && numStopsTried + 1 == numStopsNeeded) {
    //             townsVisited.add(nextTown);

    //             // create a complete route from those towns
    //             Town[] routeTowns = new Town[townsVisited.size()];
    //             townsVisited.toArray(routeTowns);
    //             routes.add(new Route(routeTowns));

    //             // clean out all the towns in the visited section except our original origin 
    //             Town originalOrigin = townsVisited.get(0);
    //             townsVisited.removeAll(townsVisited);
    //             townsVisited.add(originalOrigin);
    //             return routes;
    //         }
    //         // if we haven't found the origin and we've made too many stops, then return nothing
    //         else if (numStopsTried > numStopsNeeded) {
    //             return emptyRoutes;
    //         }

    //         else {
    //             // otherwise go through again ?
    //             this.depthFirstSearchWithExactStops(nextTown, destination, numStopsNeeded, townsVisited, routes);
    //         }
    //     }
    //     return routes;
    // }