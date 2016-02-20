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

#Notes:

I began this project using IntelliJ, and developed the majority of my tests while using IntelliJ.  Most of them were passing until I moved to Sublime (for more transparency).  Now they no longer pass, and I had a devil of a time getting them to even fail without test environment errors.  Could not figure out why.

Also, I did not finish everything.  I wrote three different versions of a depth first graph traversal algorithms, and two of the breadth first.  At first, I was going to simply use a single method to retrieve paths, but I quickly realized there were simply too many variables to keep track of.  Consequently, I decided I should turn the searchers into their own classes, and after some research, I decided to build simple graph traversal algorithms first.  I wanted classic solutions, represented as classes, using stack and queue for depth and breadth respectively.  Unfortunately, once I had built them according to what seemed logical, I found it difficult to adapt them to keep track of routes in particular.  :(  I also ran into some bugs that took a while to uncover (for example, I was forgetting to utilize my town object's equals method throughout the program instead of a double equals - no wonder it wasn't identifying comparison!).

In any case, even though I did not complete my solution due to a time crunch, I think I demonstrated that I am able to compose a program in an OOP manner, that I do value testing ( lol, I was going for test driven, even though that eventually broke down ), and that I know how to write graph traversal algorithms - which to me seemed the point of the challenge.  I also think I demonstrated the ability to learn a new programming language in a relatively short period of time (I think I spent about two days reading before jumping in).  I still have a few burning questions about Java (especially error handling ), but I feel comfortable in my ability to use it.