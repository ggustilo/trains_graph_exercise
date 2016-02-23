# trains_graph_exercise - java/junit

Essentially, this is a classic graphs problem.

Towns represent vertices or nodes.

Tracks represent edges.

These objects are held in a graph object.

I also wanted to implement route objects (paths), which could perhaps be stored for later, easier retrieval.

We are looking to find:

- the number of possible paths between two nodes
- paths that traverse a given number of nodes
- paths that have a total distance greater or less than some given number

This requires traversing the graph using both depth first and breadth first search.

#To run:

1. Compile source code (code in src file).
2. Run Main with single argument of input.txt (or other text file).  Ex: java Main input.txt

#Assumptions:

Input.txt file will contain consecutive individual lines that comprise edge descriptions, such as:

AB6
DF7
CE9

Any explicit function calls to get paths should be made in the RouteCalculator file, which contains our test data.

#Methodology:

Parsing the graph outline from an input.txt file.
Creating town, track, graph, and eventually route objects from the input.
Finding paths according to test input but calling relevant functions.