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

        System.out.println("Routes from C to C with max 3 stops: " + Main.graph.findRoutesWithMaxStops(townC, townC, 3) + "\n\n");

        // Main.graph.findRoutesWithMaxStops(townA, townC, 4); - problem #7 (fails)

	}

}