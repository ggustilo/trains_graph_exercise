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
	// public method to calculate total distance of path given array of towns

	// public method to calculate the number of routes possible given start, end and # stops

	// public method to calculate the number of routes possible given max number of stops

	// public method to calculate length of shortest route given start and end

	// public method to calculate number of different routes possible given start and end and total distance
}