import java.lang.*;

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
}
