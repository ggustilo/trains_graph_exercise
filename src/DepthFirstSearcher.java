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
		Iterator<Town> currentLevelOfNeighboringTowns = this.stack.peek();
		// if we have already visited this town, keep going
		do {
				// except if there are no more towns in our current stack level
				while (!currentLevelOfNeighboringTowns.hasNext()) {
					this.stack.pop();
						if (this.stack.isEmpty()) {
							this.next = null;
							return;
						}
					currentLevelOfNeighboringTowns = this.stack.peek();
				}
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

					// then move to the next level
					this.stack.pop();
					currentLevelOfNeighboringTowns = this.stack.peek();
					// clear out towns for the next route
					townsOnRoute.removeAll(townsOnRoute);
				}

		} while (this.visited.contains(this.next) && !(this.next.equals(this.target)));
		townsOnRoute.add(this.next);
		this.stack.push(this.graph.getAllNeighboringTowns(this.next).iterator());
	}

	@Override
	public Town next() {
		// create an empty instance to return when we run out
		// FIXME: need better error handling
		Town emptyTown = new Town("Null");
		// while there still is a next town
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
