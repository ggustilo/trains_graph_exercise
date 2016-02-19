# trains_graph_exercise

Essentially, this is a classic graphs problem.

Towns represent vertices or nodes.

Tracks represent edges.

These are held in a graph object.

We are looking to find:

- the number of possible paths between two nodes
- paths that traverse a given number of nodes
- paths that have a total distance greater or less than some given number

This requires traversing the graph using both depth first and breadth first search.

#Assumptions:

Input.txt file will contain consecutive individual lines that comprise edge descriptions, such as:

AB6
DF7
CE9

Any explicit function calls to get paths should be made in the RouteCalculator file, which contains our test data.

#Methodology:

Parsing the graph outline from an input.txt file.
Assembling town, track, graph, and eventually route objects from that file.
Finding paths according to test input.

#To run:

1. Compile source code (code in src file).
2. Run Main with single argument of input.txt (or other text file).  Ex: java Main input.txt

#Notes:

I began this project using IntelliJ, and developed the majority of my tests using IntelliJ.  Most of them were passing until I moved to Sublime.  Now they no longer pass, and I had a devil of a time getting them to even fail without test environment errors.