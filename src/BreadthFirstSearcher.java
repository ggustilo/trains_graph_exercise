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
	private Set<Town> visited = new HashSet<Town>();
	private Queue<Town> queue = new LinkedList<Town>();
	private Graph graph;

	public void setUp(Graph mainGraph, Town origin) {
		this.graph = mainGraph;
		this.queue.add(origin);
		this.visited.add(origin);
	}

	@Override
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}

	@Override
	public Town next() {
		Town next = queue.remove();
		for (Town neighboringTown : this.graph.getAllNeighboringTowns(next)) {
			if (!this.visited.contains(neighboringTown)) {
				this.queue.add(neighboringTown);
				this.visited.add(neighboringTown);
			}
		}
		return next;
	}
}