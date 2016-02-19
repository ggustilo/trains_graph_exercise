package src;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;
import java.util.NoSuchElementException;

public class DepthFirstSearcher implements Iterator<Town> {
	public List<Town> townsOnRoute = new ArrayList<Town>();
	public List<Route> routes = new ArrayList<Route>();
	private Set<Town> visited = new HashSet<Town>();
	private Deque<Iterator<Town>> stack = new LinkedList<Iterator<Town>>();
	private Graph graph;
	private Town next;
	private Town target;
	private Town origin;

	public void dfsIterator(Graph mainGraph, Town origin, Town destination) {
		this.stack.push(mainGraph.getAllNeighboringTowns(origin).iterator());
		this.graph = mainGraph;
		this.next = origin;
		this.target = destination;
		this.origin = origin;
		this.addOrigin();
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	private void addOrigin() {
		townsOnRoute.add(origin);
	}

	private void advance() {
		// get the neighboring towns iterator from the top of the stack and set it in progress
		Iterator<Town> currentLevelOfNeighboringTowns = this.stack.peek();
		// if we have already visited this town, keep going
		do {
				// except if there are no more towns in our current stack level
				while (!currentLevelOfNeighboringTowns.hasNext()) {
					//in which case, pop off this level
					System.out.println("Popping it off...");
					this.stack.pop();
						// and if there are no more levels
						if (this.stack.isEmpty()) {
							// then just return
							System.out.println("All empty");
							this.next = null;
							return;
						}
					// otherwise, get the next set of neighboring towns, and set them in progress
					// this.visited.removeAll(visited);
					currentLevelOfNeighboringTowns = this.stack.peek();
					System.out.println("Still here\n");
				}

				// keep going through the towns in our current level/iterator
				System.out.println("Iterating");
				this.next = currentLevelOfNeighboringTowns.next();

				// if current town is our target, then pop off this level, get next set of neighboring towns, set them
				// also clear the visited array
				if (this.next.equals(this.target)) {
					System.out.println("Got Target!");

					this.addOrigin();
					Town[] towns = new Town[townsOnRoute.size()];
          townsOnRoute.toArray(towns);
          Route route = new Route(towns);
          System.out.println("TOWNS: \n");
          for (Town town : route.getTowns()) {
          	System.out.print(town.getName() + " ");
          }
          System.out.println("\n Routes Num: \n");

          routes.add(route);
          System.out.println(routes.size() + "\n");

					this.stack.pop();
					System.out.println("These are visited: " + visited.size());
					currentLevelOfNeighboringTowns = this.stack.peek();
					townsOnRoute.removeAll(townsOnRoute);
				}
				
				System.out.println("Next up: " + this.next.getName());

		} while (this.visited.contains(this.next) && !(this.next.equals(this.target)));
		// add all the neighboring towns from the next town onto the stack (as an iterator)
				System.out.println("Adding to stack...");
		townsOnRoute.add(this.next);
		this.stack.push(this.graph.getAllNeighboringTowns(this.next).iterator());
		System.out.println(this.stack.size());
		System.out.println(this.visited);
	}

	@Override
	public Town next() {
		Town emptyTown = new Town("Null");
		if (this.next != null) {
			System.out.println("Currently on - " + next + " : " + next.getName());
			try {
				this.visited.add(this.next);
				System.out.println("These are towns on route: \n");
				for (Town town : townsOnRoute) {
					System.out.println(town.getName());
				}
				System.out.println("\n");
				return this.next;
			}
			finally {
				this.advance();
			}
		}
		else {
			return emptyTown;
		}
	}

	public List<Route> getRoutes() {
		return routes;
	}

}
