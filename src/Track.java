public class Track {

    private Town origin;
    private Town destination;
    private int distance;

	public static void main(String[] args) {

	}

	public Track(Town startPoint, Town endPoint, int weight) {
		this.origin = startPoint;
		this.destination = endPoint;
		this.distance = weight;
	}

    public Town getOrigin() {
        return this.origin;
    }

    public Town getDestination() {
        return this.destination;
    }

    public int getDistance() {
        return this.distance;
    }

}