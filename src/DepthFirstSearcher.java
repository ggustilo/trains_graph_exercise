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
	private Set<Town> visited = new HashSet<Town>();
	private Deque<Iterator<Town>> stack = new LinkedList<Iterator<Town>>();
	private Graph graph;
	private Town next;

	public void setUp(Graph mainGraph, Town origin) {
		this.stack.push(mainGraph.getAllNeighboringTowns(origin).iterator());
		this.graph = mainGraph;
		this.next = origin;
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	private void advance() {
		Iterator<Town> neighboringTowns = this.stack.peek();
		do {
			while (!neighboringTowns.hasNext()) {
				this.stack.pop();
				if (this.stack.isEmpty()) {
					this.next = null;
					return;
				}
				neighboringTowns = this.stack.peek();
			}
			this.next = neighboringTowns.next();
		} while (this.visited.contains(this.next));
		this.stack.push(this.graph.getAllNeighboringTowns(this.next).iterator());
	}

	@Override
	public Town next() {
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
			throw new NoSuchElementException();
		}
	}

}
