import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.io.*;

/*
Pseudocode:

Open up the input.txt file
Grab one line at a time
While there are still lines
    pass the line to a method to create town objects from it
    pass the line to a method to create track objects from it

In create town objects
    parse the first letters of the line
    append the town objects to an array list of town objects

In create track objects
    parse the last letter of the line
    append the town objects to an array list of track objects

When there are no lines left,
    create a new graph with the array list of town objects and the array list of track objects

*/
public class Main {

    private List<Town> townsForGraph = new ArrayList<Town>();
    private List<Track> tracksForGraph = new ArrayList<Track>();

    public static void main(String[] args) {
        Main main = new Main();
        main.setUp();
    }


    public void setUp() {

        // The name of the file to open.
        String fileName = "input.txt";

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
                createObjects(line);
            }

            // Make a graph with all our new objects

            makeGraph();
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

        Graph graph = new Graph(towns, tracks);
        System.out.println(graph);
        System.out.println(graph.getTowns().length);
        System.out.println(graph.getTracks().length);
    }
}
