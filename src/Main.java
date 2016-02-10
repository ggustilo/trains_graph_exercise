import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String [] args) {

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
                createObject(line);
            }

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

    private static void createObject(String line) {
        Town origin = new Town(line.substring(0, 1));
        Town destination = new Town(line.substring(1, 2));
        int distance = Integer.parseInt(line.substring(2));
        new Track(origin, destination, distance);
    }

}
