package src;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;

public class BreadthFirstSearcher implements Iterator<Town> {
	public List<Town> townsOnRoute = new ArrayList<Town>();
	public List<Route> routes = new ArrayList<Route>();
	private Set<Town> visited = new HashSet<Town>();
	private Queue<Town> queue = new LinkedList<Town>();
	private Graph graph;
	private Town target;
	private int stops;

	public void setUp(Graph mainGraph, Town origin, Town destination, int numStopsExactly) {
		this.graph = mainGraph;
		this.queue.add(origin);
		this.visited.add(origin);
		this.target = destination;
		this.stops = numStopsExactly;
	}

	@Override
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}

	@Override
	public Town next() {
		Town emptyTown = new Town("Null");
		// get the next town
		Town next = queue.remove();
		// find all the adjacent towns
		for (Town town : this.graph.getAllNeighboringTowns(next)) {
			if (!this.visited.contains(town)) {
				System.out.println(town.getName());
				this.queue.add(town);
				this.visited.add(town);
			}
		}
		if (next != null) {
			return next;
		}
		else {
			return emptyTown;
		}
	}
}