public class RouteCalculator {
	public static void main(String[] args) {
		// get input from text file
		// create town objects
		// create track objects
		System.out.println("Hello from our new IDE");
		System.out.println("This is a new line now");
		// call methods to do these:

			// distance of a path:
				// 1. The distance of the route A-B-C.
				// 2. The distance of the route A-D.
				// 3. The distance of the route A-D-C.
				// 4. The distance of the route A-E-B-C-D.
				// 5. The distance of the route A-E-D.

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