package src;

public class RouteCalculator {
	public static void run() {
				System.out.println("Hello.  Set up is complete.  Running our tests...");

				Town townA = Main.graph.getTown("A");
				Town townB = Main.graph.getTown("B");
				Town townC = Main.graph.getTown("C");
				Town townD = Main.graph.getTown("D");
				Town townE = Main.graph.getTown("E");

				Town[] towns1 = {townA, townB, townC};
				Town[] towns2 = {townA, townD};
				Town[] towns3 = {townA, townD, townC};
				Town[] towns4 = {townA, townE, townB, townC, townD};
				Town[] towns5 = {townA, townE, townD};

				Route routeABC = new Route(towns1);
				Route routeAD = new Route(towns2);
				Route routeADC = new Route(towns3);
				Route routeAEBCD = new Route(towns4);
				Route routeAED = new Route(towns5);

				// 1. The distance of the route A-B-C.
		    System.out.println("Total Distance of Route ABC: " + Main.graph.findTotalDistanceOfRoute(routeABC));
				// 2. The distance of the route A-D.
        System.out.println("Total Distance of Route AD: " + Main.graph.findTotalDistanceOfRoute(routeAD));
				// 3. The distance of the route A-D-C.
        System.out.println("Total Distance of Route ADC: " + Main.graph.findTotalDistanceOfRoute(routeADC));
				// 4. The distance of the route A-E-B-C-D.
        System.out.println("Total Distance of Route AEBCD: " + Main.graph.findTotalDistanceOfRoute(routeAEBCD));
				// 5. The distance of the route A-E-D.
        System.out.println("Total Distance of Route AED: " + Main.graph.findTotalDistanceOfRoute(routeAED) + "\n\n");

        // System.out.println(Main.graph.findRoutesWithMaxStops(townC, townC, 3) + "\n\n\n");

        // System.out.println(Main.graph.findRoutesWithExactStops(townA, townC, 4));

        // System.out.println(Main.graph.getAllNeighboringTowns(townA));

        Main.graph.findAllRoutesBetweenTwoTowns(townA, townC);


			// number of trips given start and end and number of stops:
					// 6. The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
					// 7. The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).

			// length of shortest route given start and end:
				// 8. The length of the shortest route (in terms of distance to travel) from A to C.
				// 9. The length of the shortest route (in terms of distance to travel) from B to B.

			// number of different routes possible given start and end and total distance:
				// 10. The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
	}

}