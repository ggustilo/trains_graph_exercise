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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (distance != track.distance) return false;
        if (!origin.equals(track.origin)) return false;
        return destination.equals(track.destination);

    }

    @Override
    public int hashCode() {
        int result = origin.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + distance;
        return result;
    }
}