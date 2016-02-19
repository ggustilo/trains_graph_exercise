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

	public void setUp(Graph mainGraph, Town origin, Town destination) {
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
					this.stack.pop();
						// and if there are no more levels
						if (this.stack.isEmpty()) {
							// then just return
							this.next = null;
							return;
						}
					// otherwise, get the next set of neighboring towns, and set them in progress
					currentLevelOfNeighboringTowns = this.stack.peek();
				}

				// keep going through the towns in our current level/iterator
				this.next = currentLevelOfNeighboringTowns.next();

				// if current town is our target, then:
				if (this.next.equals(this.target)) {
					// add the origin to the beginning of the townsOnRoute array (for complete route)
					this.addOrigin();
					
					// then create a new route and add it to routes
					Town[] towns = new Town[townsOnRoute.size()];
          townsOnRoute.toArray(towns);
          Route route = new Route(towns);
          routes.add(route);

					// then pop off the current level of the stack
					this.stack.pop();
					// set the next level in progress
					currentLevelOfNeighboringTowns = this.stack.peek();
					// remove all the towns in townsOnRoute - clear it out for next route
					townsOnRoute.removeAll(townsOnRoute);
				}

		} while (this.visited.contains(this.next) && !(this.next.equals(this.target)));
		// add current town to our townsOnRoute
		townsOnRoute.add(this.next);
		// add all the neighboring towns from the next town onto the stack (as an iterator)
		this.stack.push(this.graph.getAllNeighboringTowns(this.next).iterator());
	}

	@Override
	public Town next() {
		Town emptyTown = new Town("Null");
		if (this.next != null) {
			try {
				this.visited.add(this.next);
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
