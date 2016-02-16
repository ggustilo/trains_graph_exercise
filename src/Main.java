package src;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.io.*;

public class Main {

    /*
    Every time this program is run, we assume it will run on a single text file.
    Thus, we assume that every instance of Main in this program will be a singleton
    and inextricably combined with the graph which is the interface for a collection of objects
    extracted from that text file.
     */

    private List<Town> townsForGraph = new ArrayList<Town>();
    private List<Track> tracksForGraph = new ArrayList<Track>();
    public static Graph graph;
    private static Main instance;

    public static void main(String[] args) {

        String fileName = args[0];

        if (instance == null) {
            instance = new Main();
        }

        instance.setUp(fileName);
        RouteCalculator routeCalculator = new RouteCalculator();
        routeCalculator.run();
    }

    public void setUp(String fileName) {

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                this.createObjects(line);
            }

            // Make a graph with all our new objects
            this.makeGraph();
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    private void createObjects(String line) {
        Town origin = new Town(line.substring(0, 1));
        Town destination = new Town(line.substring(1, 2));
        int distance = Integer.parseInt(line.substring(2));
        Track newTrack = new Track(origin, destination, distance);

        if (!townsForGraph.contains(origin)) {
            townsForGraph.add(origin);
        }
        else {
            origin = null;
        }

        if (!townsForGraph.contains(destination)) {
            townsForGraph.add(destination);
        }
        else {
            destination = null;
        }

        if (!tracksForGraph.contains(newTrack)) {
            tracksForGraph.add(newTrack);
        }
        else {
            newTrack = null;
        }
    }

    private void makeGraph() {
        Track[] tracks = new Track[tracksForGraph.size()];
        tracksForGraph.toArray(tracks);

        Town[] towns = new Town[townsForGraph.size()];
        townsForGraph.toArray(towns);

        graph = new Graph(towns, tracks);
    }
}
