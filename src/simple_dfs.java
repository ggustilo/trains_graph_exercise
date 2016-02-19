 // public List<Route> findRoutesWithMaxStops(Town origin, Town destination, int maxNumStopsAllowed) {
 //        List<Town> townsVisited = new ArrayList<Town>();
 //        List<Route> routes = new ArrayList<Route>();
 //        Town previousTown = origin;
 //        Town currentTown = origin;
 //        Town nextTown = this.findNextTown(townsVisited, currentTown);
 //        int totalNumStopsAllowed = maxNumStopsAllowed + 1;
 //        int counter = 0;

 //        do {
 //            townsVisited.add(nextTown);
 //            System.out.println("Previous Town: " + previousTown.getName());
 //            System.out.println("Current Town: " + currentTown.getName());
 //            System.out.println("Next Town: " + nextTown.getName());
 //            if (nextTown == destination) {
 //                currentTown = nextTown;
 //                townsVisited.add(0, origin);

 //                Town[] routeTowns = new Town[townsVisited.size()];
 //                townsVisited.toArray(routeTowns);
 //                Route route = new Route(routeTowns);
 //                routes.add(route);
 //                this.displayRoutes(routes);

 //                townsVisited.removeAll(townsVisited);
 //                currentTown = origin;
 //                nextTown = this.findNextTown(townsVisited, previousTown);
 //                counter = 0;
 //            }
 //            else { 
 //                currentTown = nextTown;
 //                nextTown = this.findNextTown(townsVisited, currentTown);
 //            }
 //            counter += 1;
 //        } while (counter <= totalNumStopsAllowed);

 //        this.displayRoutes(routes);
 //        return routes;
 //    }