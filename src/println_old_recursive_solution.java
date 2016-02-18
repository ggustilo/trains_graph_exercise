// public List<Route> depthFirstSearchWithMaxStops(Town origin, Town destination, int maxNumStopsAllowed, List<Town> townsVisited, List<Route> routes) {
//         int numStopsTried = townsVisited.size();
//         townsVisited.add(origin);
//         List<Track> tracksFromOrigin = this.findAllTracksOutOfTown(origin);

//             System.out.println("\nNew call...\n");
//             System.out.println("Origin:" + origin.getName() + "\n");
//             for (Track track : tracksFromOrigin) {
//                 System.out.print("Returned tracks:" + track.getDestination().getName() + ", ");
//             }
//             System.out.println("\n Number of Stops tried so far:" + numStopsTried);

//         for (Track track : tracksFromOrigin) {
//             Town nextTown = track.getDestination();

//                 System.out.println("This is the next town:" + nextTown.getName());
//                 System.out.println("Is Destination?:" + nextTown.equals(destination));

//             if (nextTown.equals(destination)) {
//                 numStopsTried += 1;
//                 townsVisited.add(nextTown);

//                     System.out.println("Number of stops when we have a route:" + numStopsTried);

//                 Town[] routeTowns = new Town[townsVisited.size()];
//                 townsVisited.toArray(routeTowns);
//                 routes.add(new Route(routeTowns));

//                     System.out.println("Towns visited so far in Route: ");
//                     for (Town town : townsVisited) {
//                         System.out.print(town.getName() + "  ");
//                     }
//                     System.out.println("\n**************\nGotta Route!\n");
//                     System.out.println("Num routes:" + routes.size());

//                 numStopsTried = 0;
//                 Town originalOrigin = townsVisited.get(0);
//                 townsVisited.removeAll(townsVisited);
//                 townsVisited.add(originalOrigin);
//                 return routes;
//             }
//             else if (numStopsTried > maxNumStopsAllowed) {
//                     System.out.println("There were no routes that fulfilled the requested paramenters.");
//                 return routes;
//             }
//             else {
//                     System.out.println("Try again with new origin of: "+ nextTown.getName());
//                     System.out.println("Towns visited so far are: ");
//                     for (Town town : townsVisited) {
//                         System.out.print(town.getName() + "  ");
//                     }

//                 numStopsTried += 1;
//                 this.depthFirstSearchWithMaxStops(nextTown, destination, maxNumStopsAllowed, townsVisited, routes);
//             }
//         }
//         List<Route> emptyRoutes = new ArrayList<Route>();
//         return emptyRoutes;
//     }

//     public List<Route> findRoutesWithExactStops(Town origin, Town destination, int numStopsNeeded) {
//         List<Town> townsVisited = new ArrayList<Town>();
//         List<Route> routes = new ArrayList<Route>();
//         routes.addAll(this.depthFirstSearchWithExactStops(origin, destination, numStopsNeeded, townsVisited, routes));
//         this.displayRoutes(routes);
//         return routes;
//     }

//     public List<Route> depthFirstSearchWithExactStops(Town origin, Town destination, int numStopsNeeded, List<Town> townsVisited, List<Route> routes) {
//         List<Route> emptyRoutes = new ArrayList<Route>();
//         int numStopsTried = townsVisited.size();
//         townsVisited.add(origin);
//         List<Track> tracksFromOrigin = this.findAllTracksOutOfTown(origin);

//             System.out.println("\nNew call...\n");
//             System.out.println("Origin:" + origin.getName() + "\n");
//             for (Track track : tracksFromOrigin) {
//                 System.out.print("Returned tracks:" + track.getDestination().getName() + ", ");
//             }
//             System.out.println("\n Number of Stops tried so far:" + numStopsTried);

//         for (int i = 0; i < tracksFromOrigin.size() - 1; i++) {
//             Town nextTown = tracksFromOrigin.get(i).getDestination();

//                 System.out.println("This is the next town:" + nextTown.getName());
//                 System.out.println("Is Destination?:" + (nextTown.equals(destination) && numStopsTried == numStopsNeeded));

//             if (nextTown.equals(destination) && numStopsTried + 1 == numStopsNeeded) {
//                 townsVisited.add(nextTown);

//                     System.out.println("Number of stops when we have a route:" + numStopsTried);

//                 Town[] routeTowns = new Town[townsVisited.size()];
//                 townsVisited.toArray(routeTowns);
//                 routes.add(new Route(routeTowns));

//                     System.out.println("Towns visited so far in Route: ");
//                     for (Town town : townsVisited) {
//                         System.out.print(town.getName() + "  ");
//                     }
//                     System.out.println("\n**************\nGotta Route!\n");
//                     System.out.println("Num routes:" + routes.size());

//                 Town originalOrigin = townsVisited.get(0);
//                 townsVisited.removeAll(townsVisited);
//                 townsVisited.add(originalOrigin);
//                 return routes;
//             }
//             else if (townsVisited.size() > numStopsNeeded) {
//                     System.out.println("There were no routes that fulfilled the requested paramenters.");
//                 return emptyRoutes;
//             }
//             else {
//                     System.out.println("Try again with new origin of: "+ nextTown.getName());
//                     System.out.println("Towns visited so far are: ");
//                     for (Town town : townsVisited) {
//                         System.out.print(town.getName() + "  ");
//                     }
//                 this.depthFirstSearchWithExactStops(nextTown, destination, numStopsNeeded, townsVisited, routes);

//             }
//         }
//         return routes;
//     }